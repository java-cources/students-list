package com.studentlist.controller;

import com.studentlist.db.DbManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getMainPage(Model model) {
        model.addAttribute("students", DbManager.getStudents());

        return "index";
    }
}
