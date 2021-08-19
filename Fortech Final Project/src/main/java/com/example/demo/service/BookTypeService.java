package com.example.demo.service;

import com.example.demo.entities.BookTypeModel;
import com.example.demo.repository.BookTypeRepositoyry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookTypeService {

    @Autowired
    private BookTypeRepositoyry bookTypeRepositoyry;

    public List<BookTypeModel> getTypes() {
        return bookTypeRepositoyry.findAll();
    }
}
