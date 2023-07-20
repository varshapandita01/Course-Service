package com.courses.CourseController;

import com.courses.Course.Course;
import com.courses.CourseService.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from the Angular app URL
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity getCoursesByTechnology(@RequestParam("technology") String technology) {
        List<Course> getCourseByTechnology = courseService.getCoursesByTechnology(technology);
        if(getCourseByTechnology.size()>0)
        return  ResponseEntity.status(HttpStatus.OK).body(getCourseByTechnology);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records Found");
    }
    @GetMapping("/getall")
    public ResponseEntity findallCourseData() {
        List<Course> getAllCourses = courseService.findallCourseData();
        if(getAllCourses.size()>0)
            return  ResponseEntity.status(HttpStatus.OK).body(getAllCourses);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records Found");


    }

    @DeleteMapping("/delete/{courseName}")
    public ResponseEntity deleteByCourseName(@PathVariable(name = "courseName") String courseName){
        boolean isDeleted =   courseService.deleteCourse(courseName);
        if(isDeleted)
            return ResponseEntity.ok("Course Deleted Successfully");
            else
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records Found");

    }

        @PostMapping("/add")
    public ResponseEntity<Course> addCourseData (@RequestBody Course course){
        Course savedCourse =  courseService.addCourseData(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);

    }
    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity getCourseByDuration(@RequestParam("minDuration") int minDuration, @RequestParam("maxDuration") int maxDuration) {
        List<Course> getCourses = courseService.getCoursesByDuration(minDuration, maxDuration);
        if (getCourses.size() > 0)
            return ResponseEntity.status(HttpStatus.OK).body(courseService.getCoursesByDuration(minDuration, maxDuration));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records Found");
    }
    }

