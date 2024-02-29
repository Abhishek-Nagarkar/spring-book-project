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

import com.kpit.springproject.layer2.Book;
import com.kpit.springproject.layer4.BookService;

// @RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookSvc;

    // read all
    @GetMapping("/findAllBooks")
    public ResponseEntity getAllBooks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.bookSvc.findAllBooks());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // read single
    @GetMapping("/findBook/{bookId}")
    public ResponseEntity findABook(@PathVariable("bookId") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.bookSvc.findBook(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        // return this.bookSvc.findBook(id);
    }

    // create
    @PostMapping("/addBook")
    public ResponseEntity<String> addABook(@RequestBody Book book){
        try {
            this.bookSvc.addBook(book);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("Book added successfully with id: "+book.getBookId());
        } catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    // update
    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        try {
            this.bookSvc.updateBook(book);
            return ResponseEntity.status(HttpStatus.OK).body("Book updated successfully with id: "+book.getBookId());
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    // delete
    @DeleteMapping("/deleteBook/{bookId}")
    
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") int id){
        try {
            this.bookSvc.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully with id: "+id);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
