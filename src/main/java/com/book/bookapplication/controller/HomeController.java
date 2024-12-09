package com.book.bookapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String Home() {
        return "index";
    }

    @GetMapping("/admin/dashboard")
    public String Dashboard() {
        return "admin-dashboard";
    }


}
