package com.example.demo.service;
import com.example.demo.entities.AuthorModel;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorModel> displayAuthors() {
        List<AuthorModel> authorModelList = authorRepository.findAll();
        System.out.println("Displaying authors");
        return authorModelList;
    }

    public void addAuthor(AuthorModel author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(int id){
        authorRepository.deleteById(id);
    }

    public AuthorModel findById(int id){
        Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(id);
        return optionalAuthorModel.get();
    }

    public void edit(AuthorModel editedAuthor) {
        authorRepository.save(editedAuthor);
    }
}
