package com.demo.demo_web.user.controller;

import com.demo.demo_web.user.entity.User;
import com.demo.demo_web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String loadReportPage() {
        List<User> userList = userService.getUserList();

        return "user/report";
    }
}
