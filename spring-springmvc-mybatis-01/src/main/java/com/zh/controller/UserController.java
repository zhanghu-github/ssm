package com.zh.controller;

import com.zh.model.User;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<User> userList = userService.findAll();

        ModelAndView mav = new ModelAndView("user");
        mav.addObject("message", Arrays.toString(userList.toArray()));
        return mav;
    }

}
