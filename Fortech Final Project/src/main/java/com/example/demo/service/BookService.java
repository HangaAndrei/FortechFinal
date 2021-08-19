package com.example.demo.service;
import com.example.demo.entities.BookModel;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> getBooks(){
        List<BookModel> books = bookRepository.findAll();
        return books;
    }

    public void addBook(BookModel bookModel) {
        bookRepository.save(bookModel);
    }

    public BookModel findBook(int id) {
        return bookRepository.findById(id).get();
    }
}
