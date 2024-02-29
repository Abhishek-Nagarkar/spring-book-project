package com.kpit.springproject.layer3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpit.springproject.layer2.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>   {
    
}
