package com.example.demo.controller;

import com.example.demo.entities.BookModel;
import com.example.demo.entities.BookTypeModel;
import com.example.demo.service.BookService;
import com.example.demo.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookTypeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @GetMapping("setBookType")
    public String setBookType(Model model) {
        List<BookModel> books = bookService.getBooks();
        List<BookTypeModel> bookTypeModels = bookTypeService.getTypes();
        model.addAttribute("books", books);
        model.addAttribute("bookTypes", bookTypeModels);
        return "set-book-type";
    }
}
