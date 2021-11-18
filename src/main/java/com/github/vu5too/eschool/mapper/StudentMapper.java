package com.github.vu5too.eschool.mapper;

import com.github.vu5too.eschool.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO student(name, email) VALUES (#{name}, #{email})")
    long insert(Student student);

    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(@Param("id") long id);

    @Delete("DELETE FROM student WHERE id = #{id}")
    long deleteById(Integer id);

}