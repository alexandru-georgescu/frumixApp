package com.trainingup.trainingupapp.service;

import com.trainingup.trainingupapp.TrainingUpAppApplication;
import com.trainingup.trainingupapp.repository.CourseRepository;
import com.trainingup.trainingupapp.repository.UserRepository;
import com.trainingup.trainingupapp.tables.Course;
import com.trainingup.trainingupapp.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * With DB implementation.
 */
@RestController
public class TrainingController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> introProject(ModelAndView model) {
        User newUser = TrainingUpAppApplication.createUser("MIREL", "DA@GMAIL.COM", "LIVIU", "NORMAL");
        Course newCourse = TrainingUpAppApplication.createCourse("BANANE", LocalDate.MIN, LocalDate.MAX, 10, 20);

        courseRepository.saveAndFlush(newCourse);

        List<Course> courses = newUser.getCourses();
        courses.add(newCourse);
        newUser.setCourses(courses);

        userRepository.saveAndFlush(newUser);
        return userRepository.findAll();
    }

}

