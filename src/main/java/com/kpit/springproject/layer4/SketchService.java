package com.kpit.springproject.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpit.springproject.layer2.Sketch;


@Service
public interface SketchService {
    // create
    void addSketch(Sketch sketchObj);

    // read single
    Sketch findSketch(int sketchId);

    // read all
    List<Sketch> findAllSketches();

    // update
    void updateSketch(Sketch sketchObj);

    // delete
    void deleteSketch(int sketchId);
}
