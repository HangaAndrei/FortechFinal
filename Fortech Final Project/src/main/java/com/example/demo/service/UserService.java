package com.example.demo.service;
import com.example.demo.entities.UtilizatorModel;
import com.example.demo.exceptions.FirstNameException;
import com.example.demo.exceptions.LastNameException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UtilizatorModel> displayUsers(){
        List<UtilizatorModel> users = userRepository.findAll();
        return users;
    }

    public void addUser(UtilizatorModel utilizatorModel){
        if(utilizatorModel.getFirstName().length() <= 3) {
            RuntimeException exception = new FirstNameException("First name too short");
            throw exception;
        }
        else if (utilizatorModel.getLastName().length() <= 3) {
            RuntimeException exception = new LastNameException("Last name too short");
            throw exception;
        }
        else {
            userRepository.save(utilizatorModel);
        }
    }

    public UtilizatorModel getUser(int id) {
        Optional<UtilizatorModel> utilizatorModelOptional = userRepository.findById(id);
        return utilizatorModelOptional.get();
    }

    public void editUser(UtilizatorModel utilizatorModel) {
        userRepository.save(utilizatorModel);
    }
}
