package com.courses.CourseService;

import com.courses.Course.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCoursesByTechnology(String technology);
    List<Course> findallCourseData();
    boolean deleteCourse(String courseName);
    Course addCourseData(Course course);
    List<Course> getCoursesByDuration(int minDuration, int maxDuration);


}
