package com.kpit.springproject.layer5;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.springproject.layer2.Sketch;
import com.kpit.springproject.layer4.SketchService;


@RestController
@RequestMapping("/sketch")
@CrossOrigin(origins = "http://localhost:4200")
public class SketchController {

    @Autowired
    private SketchService sketchSvc;

    // read all
    @GetMapping("/findAll")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.sketchSvc.findAllSketches());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // read single
    @GetMapping("/find/{sketchId}")
    public ResponseEntity find(@PathVariable("sketchId") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.sketchSvc.findSketch(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        // return this.bookSvc.findBook(id);
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Sketch sketch){
        try {
            this.sketchSvc.addSketch(sketch);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("sketch added successfully with id: "+sketch.getDrawingId());
        } catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    // update
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Sketch sketch){
        try {
            this.sketchSvc.updateSketch(sketch);
            return ResponseEntity.status(HttpStatus.OK).body("sketch updated successfully with id: "+sketch.getDrawingId());
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    // delete
    @DeleteMapping("/delete/{sketchId}")
    
    public ResponseEntity<String> delete(@PathVariable("sketchId") int id){
        try {
            this.sketchSvc.deleteSketch(id);;
            return ResponseEntity.status(HttpStatus.OK).body("sketch deleted successfully with id: "+id);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
