package com.trainingup.trainingupapp.controller;

import com.trainingup.trainingupapp.TrainingUpAppApplication;
import com.trainingup.trainingupapp.repository.CourseRepository;
import com.trainingup.trainingupapp.repository.UserRepository;
import com.trainingup.trainingupapp.tables.Course;
import com.trainingup.trainingupapp.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
                "LIVIU", "NORMAL", "Mirel");
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

    @GetMapping("/login")
    public User loginPage(@RequestParam("username") String email,
                          @RequestParam("password") String password,
                          ModelAndView model) {

        Optional<User> user = userRepository.findAll().stream().filter(u -> {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
            return false;
        }).findFirst();
        return user.orElse(null);
    }
}
