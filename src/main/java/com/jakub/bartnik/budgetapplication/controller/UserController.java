package com.jakub.bartnik.budgetapplication.controller;

import com.jakub.bartnik.budgetapplication.model.User;
import com.jakub.bartnik.budgetapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String getForm(Model model) {
        model.addAttribute("newUser", new User());
        return "user_form";
    }

    @PostMapping("/add")
    public String submitForm(User user) {
        log.info("Received: " + user);
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);
        return "user_list";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam(name = "userId") Long id ){
        userService.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(name = "id") Long userId, Model model) {
        Optional<User> userOptional = userService.findUser(userId);
        if(userOptional.isPresent()){
            User foundUser = userOptional.get();
            model.addAttribute("user", foundUser);

            // jeśli studenta udało się znaleźć, to wyświetlamy stronę details.
            return "user_details";
        }

        // w tym przypadku nie udało się odnaleźć studenta.
        return "redirect:/user/list";
    }
}

