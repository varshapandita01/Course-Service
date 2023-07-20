package com.courses.CourseRepository;

import com.courses.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTechnology(String technology);
    Course findByCourseName(String courseName);
    List<Course> findByCourseDurationBetween(int minDuration, int maxDuration);

}
