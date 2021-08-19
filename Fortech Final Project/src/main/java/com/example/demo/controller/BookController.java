package com.example.demo.controller;

import com.example.demo.entities.AuthorModel;
import com.example.demo.entities.BookModel;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String displayBooks(Model model) {
        List<BookModel> bookModelList = bookService.getBooks();
        model.addAttribute("books", bookModelList);
        return "list-book";
    }

    @GetMapping("addBookPage")
    public String viewAddBookPage(Model model) {
        model.addAttribute("newBook", new BookModel());
        List<AuthorModel> authors = authorService.displayAuthors();
        model.addAttribute("authors", authors);
        return "add-book";
    }

    @GetMapping("book-add")
    public String addBook(@ModelAttribute BookModel bookModel) {
        bookService.addBook(bookModel);
        return "redirect:/books";
    }

    @GetMapping("editBookPage")
    public String editBook(@RequestParam("id") int id, Model model){
        BookModel bookModel = bookService.findBook(id);
        model.addAttribute("editBook", bookModel);
        List<AuthorModel> authors = authorService.displayAuthors();
        model.addAttribute("authors", authors);
        return "edit-book";
    }
}
