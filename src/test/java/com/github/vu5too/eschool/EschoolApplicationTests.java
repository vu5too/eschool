package com.github.vu5too.eschool;

import com.github.vu5too.eschool.controller.StudentController;
import com.github.vu5too.eschool.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EschoolApplicationTests {

	@Autowired
	StudentController studentController;

	void contextLoads() {
	}


	@Test
	void testAll() {
		Student student = studentController.findById(1);
		Assertions.assertEquals(student.getId(), 1);
	}

}
