package com.github.vu5too.eschool;

import com.github.vu5too.eschool.entity.Student;
import com.github.vu5too.eschool.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@SpringBootTest
public class MapperTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testFindById() {
        Student student = studentMapper.findById(1);
        Assert.assertEquals(student.getId(), 1);
        Assert.assertEquals(student.getName(), "Luke Skywalker");
        Assert.assertEquals(student.getEmail(), "tatooine@gmail.com");
    }

    @Test
    public void testAllAtStart() {
        List<Student> students = studentMapper.findAll();
        Assert.assertEquals(students.size(), 6);
    }

}
