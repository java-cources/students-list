package com.studentlist.db;

import com.studentlist.model.Student;
import lombok.Getter;

import java.util.ArrayList;

public class DbManager {

    @Getter
    private static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Alibek", "Myltykbayev", 95, "A"));
        students.add(new Student(2L, "Rasul", "Myltykbayev", 88, "B+"));
        students.add(new Student(3L, "Aruzhan", "Saparova", 76, "C+"));
        students.add(new Student(4L, "Dias", "Kenzhebayev", 91, "A-"));
        students.add(new Student(5L, "Dana", "Tulegenova", 84, "B"));
    }
}
