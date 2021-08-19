package com.example.demo.controller;

import com.example.demo.entities.UtilizatorModel;
import com.example.demo.exceptions.FirstNameException;
import com.example.demo.exceptions.LastNameException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UtilizatorController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<UtilizatorModel> utilizatorModelList = userService.displayUsers();
        model.addAttribute("users", utilizatorModelList);
        return "utilizator";
    }

    @GetMapping("add-user")
    public String addUserPage(Model model) {
        model.addAttribute("userToBeAdded", new UtilizatorModel());
        return "utilizator-add";
    }

    @GetMapping("user-edit")
    public String editUser(@ModelAttribute UtilizatorModel utilizatorModel) {
        userService.editUser(utilizatorModel);
        return "redirect:/users";
    }

    @GetMapping("edit-user")
    public String editUserPage(@RequestParam int id, Model model) {
        UtilizatorModel utilizatorModel = userService.getUser(id);
        model.addAttribute("editUser", utilizatorModel);
        return "edit-user";
    }

    @GetMapping("user-add")
    public String addUser(@ModelAttribute UtilizatorModel utilizatorModel, Model model) {
        try {
            userService.addUser(utilizatorModel);
            return "redirect:/users";
        } catch (FirstNameException runtimeException) {
            model.addAttribute("userToBeAdded", utilizatorModel);
            model.addAttribute("errorMessageFirstName", runtimeException.getMessage());
            return "utilizator-add";
        } catch (LastNameException lastNameException) {
            model.addAttribute("userToBeAdded", utilizatorModel);
            model.addAttribute("errorMessageLastName", lastNameException.getMessage());
            return "utilizator-add";
        }

    }
}
