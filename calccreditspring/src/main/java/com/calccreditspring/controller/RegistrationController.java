package com.calccreditspring.controller;

import com.calccreditspring.domain.Role;
import com.calccreditspring.domain.User;
import com.calccreditspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController
{
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model)

    {
        User userFromDb=userRepo.findByUsername(user.getUsername());
        if(userFromDb!=null)
        {
            model.put("usr", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));/*создает сет с одним единственным значением*/
        userRepo.save(user);


        return "redirect:/login";/*при успешной авторизации будем переходить на стр.login*/
    }

}
