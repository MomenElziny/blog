package com.example.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blog.dto.RegistrationDto;
import com.example.blog.model.User;
import com.example.blog.service.UserService;

import jakarta.validation.Valid;
@Controller
public class AuthController {
    private  UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public AuthController() {
    }
    // handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model)
    {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user",user);
        return "register";
    }
    
    // handle user registration form submit request
    
    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                BindingResult result,Model model)
    {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser!=null)
        {
            result.rejectValue("email","user already exists");
        }
        if(result.hasErrors())
        {
            model.addAttribute("user",user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }
}
