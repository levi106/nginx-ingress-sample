package com.example.springsessionapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        String message = (String)session.getAttribute("MESSAGE");
        session.setAttribute("MESSAGE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        model.addAttribute("message", message != null ? "Last access time: " + message : "<empty>");
        return "index";
    }
}
