package com.kpit.springproject.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpit.springproject.layer2.Book;

@Service
public interface BookService {
    // create
    void addBook(Book bookObj);

    // read single
    Book findBook(int bookId);

    // read all
    List<Book> findAllBooks();

    // update
    void updateBook(Book bookObj);

    // delete
    void deleteBook(int bookId);
}
