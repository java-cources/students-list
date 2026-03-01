package com.studentlist.controller;

import com.studentlist.db.DbManager;
import com.studentlist.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getMainPage(Model model) {
        model.addAttribute("students", DbManager.getStudents());

        return "index";
    }

    @PostMapping("/add-student")
    public String save(Student student) {
        DbManager.addStudent(student);

        return "redirect:/";
    }
}
