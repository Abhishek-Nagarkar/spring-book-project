package com.kpit.springproject.layer2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sketch_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sketch {
    @Id
    @Column(name="sketch_id")
    private int drawingId;

    @Column(name="sketch_name")
    private String drawingName;

    @Column(name="sketch_cost")
    private double drawingCost;
    
}
