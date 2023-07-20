package com.courses.CourseService.CourseServiceImpl;

import com.courses.Course.Course;
import com.courses.CourseRepository.CourseRepository;
import com.courses.CourseService.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCoursesByTechnology(String technology) {
        return courseRepository.findByTechnology(technology);
    }

    @Override
    public List<Course> findallCourseData() {
        return courseRepository.findAll();
    }

    @Override
    public boolean deleteCourse(String courseName) {
        Course course = courseRepository.findByCourseName(courseName);
        if(course != null) {
            courseRepository.delete(course);
            return true;
        }
        else
            return false;
    }

    @Override
    public Course addCourseData(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCoursesByDuration(int minDuration, int maxDuration) {
        return courseRepository.findByCourseDurationBetween(minDuration, maxDuration);
    }
}
