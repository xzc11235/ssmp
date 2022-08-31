package com.ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssm.domain.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
//    boolean save(Course course);
//    boolean update(Course course);
    boolean delete(Integer id);
    IPage<Course> getpage(int cur,int size);

    IPage<Course> getpage(int cur, int size, Course course);

//    Course getbyid(Integer id);
//    List<Course>getall();
}
