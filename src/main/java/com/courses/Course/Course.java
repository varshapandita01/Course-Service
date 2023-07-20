package com.courses.Course;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Course")
@NoArgsConstructor
@Getter@Setter
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @NotNull(message = "Course Name is required")
    @Column(name = "course_name")
    private String courseName;
    @NotNull(message = "Course Duration is required")
    @Column(name = "course_duration")
    private int courseDuration;
    @NotNull(message = "Course Description is required")
    @Column(name = "course_description")
    private String courseDescription;
    @NotNull(message = "Technology is required")
    private String technology;
    @NotNull(message = "Launch URL is required")
    @Column(name = "launch_url")
    private String launchUrl;
}
