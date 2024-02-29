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
@Table(name="book_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(name="bookId")
    private int bookId;

    @Column(name="bookTitle")
    private String bookTitle;

    @Column(name="bookAuthor")
    private String bookAuthor;

    @Column(name="bookPrice")
    private double bookPrice;

    @Column(name="bookPages")
    private int bookPages;
}
