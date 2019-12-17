package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Course;

@Mapper
public interface CourseMapper {

    List<Course> findAll();
    void update(Course course);
    void insert(Course course);
    void delete(int id);

}

