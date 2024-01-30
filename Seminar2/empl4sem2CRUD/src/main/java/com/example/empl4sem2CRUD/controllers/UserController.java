package com.example.empl4sem2CRUD.controllers;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @RequestMapping (value = "user-update/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String updateUser (User user, @PathVariable int id){
        System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getId());
       // userService.update(user);
        return "user-update";

    }

    //@GetMapping("user-delete/{id}")
}
