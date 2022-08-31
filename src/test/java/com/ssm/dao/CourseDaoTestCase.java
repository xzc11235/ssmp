package com.ssm.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssm.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;

@SpringBootTest//(classes = BookDao.class)
public class CourseDaoTestCase {
    @Autowired
    private CourseDao courseDao;

    @Test
    void testselect(){

        System.out.println(courseDao.selectById(1));
        //System.out.println(courseDao.qwer(7));
    }

    @Test
    void testsave(){
        Course course=new Course();
        course.setTitle("测试");
        course.setDept_name("测试");
        course.setCredits(2);
        courseDao.insert(course);

    }
    @Test
    void testupdate(){
        Course course=new Course();
        course.setId(11);
        course.setTitle("更新测试");
        course.setDept_name("更新测试");
        course.setCredits(2);
        courseDao.updateById(course);

    }
    @Test
    void testdelete(){

        courseDao.deleteById(11);

    }
    @Test
    void testgetall(){
        System.out.println(courseDao.selectList(null));

    }
    @Test
    void testgetpage(){
        IPage page=new Page(1,5);
        courseDao.selectPage(page,null);

    }


    @Test
    void testgetby(){
        QueryWrapper<Course> qw=new QueryWrapper<>();
        qw.eq("dept_name","计算机学院");
        courseDao.selectList(qw);
    }

    @Test
    void testgetby2(){
        LambdaQueryWrapper<Course> lqw=new LambdaQueryWrapper<>();
        lqw.like(false,Course::getDept_name,"计算机学院");
        courseDao.selectList(lqw);
    }
}
