package com.ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssm.controller.Utils.R;
import com.ssm.domain.Course;
import com.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public R getall(){
        return new R(true,courseService.list());
    }
    @PostMapping
    public R save(@RequestBody Course course)throws IOException {
        return new R(courseService.save(course));
    }

    @PutMapping
    public R update(@RequestBody Course course){
        return new R(courseService.updateById(course));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(courseService.delete(id));
    }
    @GetMapping("{id}")
    public R getbyid (@PathVariable Integer id){
        return new R(true,courseService.getById(id));
    }
    @GetMapping("{cur}/{size}")
    public R getpage(@PathVariable int cur,@PathVariable int size,Course course){
        System.out.println(course);
        IPage<Course> page =courseService.getpage(cur,size,course);
        if (cur>page.getPages()){
            page =courseService.getpage((int)page.getPages(),size,course);
        }
        return new R(true,page);
    }


}
