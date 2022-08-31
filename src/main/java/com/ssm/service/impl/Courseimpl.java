package com.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssm.dao.CourseDao;
import com.ssm.domain.Course;
import com.ssm.service.CourseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Courseimpl extends ServiceImpl<CourseDao,Course> implements CourseService {
    @Autowired
    private CourseDao courseDao;
//    @Override
//    public boolean save(Course course) {
//        return courseDao.insert(course)>0;
//    }
//
//    @Override
//    public boolean update(Course course) {
//        return courseDao.updateById(course)>0;
//    }
//
    @Override
    public boolean delete(Integer id) {
        return courseDao.deleteById(id)>0;
    }

    @Override
    public IPage<Course> getpage(int cur, int size) {
        IPage page=new Page(cur,size);
        courseDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Course> getpage(int cur, int size, Course course) {
        LambdaQueryWrapper<Course> qw=new LambdaQueryWrapper<Course>();
        qw.like(Strings.isNotEmpty(course.getTitle()),Course::getTitle,course.getTitle());
        qw.like(Strings.isNotEmpty(course.getDept_name()),Course::getDept_name,course.getDept_name());
        qw.like(course.getCredits()!=null,Course::getCredits,course.getCredits());
        IPage page=new Page(cur,size);
        courseDao.selectPage(page,qw);
        return page;
    }

//
//    @Override
//    public Course getbyid(Integer id) {
//        return courseDao.selectById(id);
//    }
//
//    @Override
//    public List<Course> getall() {
//        return courseDao.selectList(null);
//    }
}
