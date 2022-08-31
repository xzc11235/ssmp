package com.ssm.servive;

import com.ssm.domain.Course;
import com.ssm.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;

    @Test
    void test(){
        Course course=new Course();
        course.setId(11);
        course.setCredits(2);
        course.setTitle("cs1");
        course.setDept_name("cs");
        //System.out.println(courseService.delete(11));
    }
}
