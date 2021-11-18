package com.github.vu5too.eschool.controller;

import com.github.vu5too.eschool.entity.Student;
import com.github.vu5too.eschool.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }


    @GetMapping
    public List<Student> all() {
        return studentMapper.findAll();
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable Integer id) {
        return studentMapper.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        studentMapper.deleteById(id);
    }

    @PostMapping
    public long add(@RequestBody Student student) {
        return studentMapper.insert(student);
    }


}
