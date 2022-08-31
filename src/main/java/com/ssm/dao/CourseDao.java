package com.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssm.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CourseDao extends BaseMapper<Course> {
    @Select("select * from course where id=#{id}")
    /*@Results({
            @Result(column="dept_name", property="name", jdbcType= JdbcType.VARCHAR)
    })*/
    Course qwer(Integer id);

}
