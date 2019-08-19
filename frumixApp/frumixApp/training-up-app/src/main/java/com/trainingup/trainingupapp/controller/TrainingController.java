package com.trainingup.trainingupapp.controller;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> introProject(ModelAndView model) {
        User newUser = TrainingUpAppApplication.createUser("MIREL", "DA@GMAIL.COM",
                "LIVIU", "NORMAL");
        Course newCourse = TrainingUpAppApplication.createCourse("BANANE", LocalDate.MIN,
                LocalDate.MAX, 20, 10);

        Course newCourse2 = TrainingUpAppApplication.createCourse("BANANE2", LocalDate.MIN,
                LocalDate.MAX, 20, 10);

        courseRepository.saveAndFlush(newCourse);
        courseRepository.saveAndFlush(newCourse2);

        List<Course> courses = newUser.getCourses();
        courses.add(newCourse);
        courses.add(newCourse2);
        newUser.setCourses(courses);

        userRepository.saveAndFlush(newUser);
        return userRepository.findAll();
    }
}

