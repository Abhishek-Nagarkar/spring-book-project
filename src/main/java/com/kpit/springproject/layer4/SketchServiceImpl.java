package com.kpit.springproject.layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.springproject.layer2.Sketch;
import com.kpit.springproject.layer3.SketchRepository;

@Service
public class SketchServiceImpl implements SketchService{
    @Autowired
    private SketchRepository sketchRepo;

    @Override
    public void addSketch(Sketch sketchObj) {
        // check if book already exists
        Optional<Sketch> opt = this.sketchRepo.findById(sketchObj.getDrawingId());

        if (opt.isPresent()) {
            throw new RuntimeException("Sketch already exists with id: " + sketchObj.getDrawingId());
        } else {
            sketchRepo.save(sketchObj);
        }
    }

    @Override
    public Sketch findSketch(int sketchId) {
        Optional<Sketch> opt = this.sketchRepo.findById(sketchId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RuntimeException("Sketch not found with id: " + sketchId);
        }
    }

    @Override
    public List<Sketch> findAllSketches() {
        List<Sketch> bookList = (List<Sketch>) this.sketchRepo.findAll();
        if (bookList.size() <= 0) {
            throw new RuntimeException("Sketchs not found");
        }
        return bookList;
    }

    @Override
    public void updateSketch(Sketch sketchObj) {
        Optional<Sketch> opt = this.sketchRepo.findById(sketchObj.getDrawingId());

        if (opt.isPresent()) {
            this.sketchRepo.save(sketchObj);
        } else {
            throw new RuntimeException("Sketch not found with id: " + sketchObj.getDrawingId());
        }
    }

    @Override
    public void deleteSketch(int sketchId) {
        Optional<Sketch> opt = this.sketchRepo.findById(sketchId);

        if (opt.isPresent()) {
            this.sketchRepo.delete(opt.get());
        } else {
            throw new RuntimeException("Sketch not found with id: " + sketchId);
        }
    }

}
