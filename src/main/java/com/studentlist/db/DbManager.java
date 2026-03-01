package com.studentlist.db;

import com.studentlist.model.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class DbManager {

    @Getter
    private static final ArrayList<Student> students = new ArrayList<>();

    private static final AtomicLong idGenerator = new AtomicLong();

    static {
        students.add(new Student(1L, "Alibek", "Myltykbayev", 95, "A"));
        students.add(new Student(2L, "Rasul", "Myltykbayev", 88, "B+"));
        students.add(new Student(3L, "Aruzhan", "Saparova", 76, "C+"));
        students.add(new Student(4L, "Dias", "Kenzhebayev", 49, "F"));
        students.add(new Student(5L, "Dana", "Tulegenova", 84, "B"));

        long maxId = students.stream()
                .mapToLong(Student::getId)
                .max()
                .orElse(0);

        idGenerator.set(maxId);
    }

    /**
     * Добавляем нового студента в память, перед тем как вычислим его Mark и присвоим ID
     * @param student
     */
    public static void addStudent(Student student) {
        if (student.getExam() >= 90) {
            student.setMark("A");
        } else if (student.getExam() >= 75) {
            student.setMark("B");
        } else if (student.getExam() >= 60) {
            student.setMark("C");
        } else {
            student.setMark("F");
        }

        student.setId(idGenerator.incrementAndGet());
        students.add(student);
    }
}
