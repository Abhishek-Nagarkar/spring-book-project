package com.kpit.springproject.layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.springproject.layer2.Book;
import com.kpit.springproject.layer3.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepo;

    @Override
    public void addBook(Book bookObj) {
        // check if book already exists
        Optional<Book> opt = this.bookRepo.findById(bookObj.getBookId());

        if (opt.isPresent()) {
            throw new RuntimeException("Book already exists with id: " + bookObj.getBookId());
        } else {
            bookRepo.save(bookObj);
        }
    }

    @Override
    public Book findBook(int bookId) {
        Optional<Book> opt = this.bookRepo.findById(bookId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RuntimeException("Book not found with id: " + bookId);
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> bookList = (List<Book>) this.bookRepo.findAll();
        if (bookList.size() <= 0) {
            throw new RuntimeException("Books not found");
        }
        return bookList;
    }

    @Override
    public void updateBook(Book bookObj) {
        Optional<Book> opt = this.bookRepo.findById(bookObj.getBookId());

        if (opt.isPresent()) {
            this.bookRepo.save(bookObj);
        } else {
            throw new RuntimeException("Book not found with id: " + bookObj.getBookId());
        }
    }

    @Override
    public void deleteBook(int bookId) {
        Optional<Book> opt = this.bookRepo.findById(bookId);

        if (opt.isPresent()) {
            this.bookRepo.delete(opt.get());
        } else {
            throw new RuntimeException("Book not found with id: " + bookId);
        }
    }

}
