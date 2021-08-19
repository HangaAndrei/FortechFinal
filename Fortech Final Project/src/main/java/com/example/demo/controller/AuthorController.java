package com.example.demo.controller;

import com.example.demo.entities.AuthorModel;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "author")
    public String displayAuthors(Model model) {
        List<AuthorModel> authorModelList = authorService.displayAuthors();
        model.addAttribute("title", "");
        model.addAttribute("authors", authorModelList);
        return "authors";
    }

    @GetMapping(path = "tables")
    public String displayTable(Model model) {
        List<AuthorModel> authorModelList = authorService.displayAuthors();
        model.addAttribute("title", "");
        model.addAttribute("authors", authorModelList);
        return "table";
    }

    @GetMapping(path = "add-author")
    public String viewAuthorPage(Model model) {
        model.addAttribute("newAuthor", new AuthorModel());
        return "author-add";
    }

    @GetMapping(path = "edit-author")
    public String editAuthorPage(@RequestParam int id, Model model) {
        AuthorModel foundAuthor = authorService.findById(id);
        model.addAttribute("editAuthor", foundAuthor);
        return "author-edit";
    }

    @GetMapping(path = "displaySearch")
    public String displaySearch(@RequestParam int id, Model model) {
        System.out.println("Searching for author: id:" + id);
        AuthorModel authorModel = authorService.findById(id);
        model.addAttribute("foundAuthor", authorModel);
        return "search";
    }

    @GetMapping("author-edit")
    public String editAuthor(@ModelAttribute AuthorModel editedAuthor) {
        authorService.edit(editedAuthor);
        System.out.println("Editing entry");
        return "redirect:/tables";
    }

    @GetMapping(path = "author-add")
    public String addAuthor(@ModelAttribute AuthorModel newAuthor) {
        System.out.println("Add author ->" + newAuthor.getFirstName() + " " + newAuthor.getLastName() + " " + newAuthor.getAuthorName() + " " + newAuthor.getBookName());
        authorService.addAuthor(newAuthor);
        return "redirect:/tables";
    }

    @GetMapping(path = "deleteById")
    public String deleteById(@RequestParam("id") int id) {
        System.out.println("Deleting author with id:" + id);
        authorService.deleteAuthor(id);
        return "redirect:/tables";
    }

    @GetMapping(path = "findById")
    public String findById(@RequestParam("id") int id, Model model) {
        System.out.println("Searching for author: id:" + id);
        AuthorModel authorModel = authorService.findById(id);
        model.addAttribute("foundAuthor", authorModel);
        return "view-author";
    }
}
