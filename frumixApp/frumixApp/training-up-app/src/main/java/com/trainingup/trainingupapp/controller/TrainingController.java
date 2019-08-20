
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
        return userRepository.findAll();
    }

    @GetMapping("/login")
    public User loginPage(@RequestParam("username") String email,
                          @RequestParam("password") String password,
                          ModelAndView model) {

        String emailToLowerCase = email.toLowerCase();

        if (!email.contains("@trainup.com"))
            return null;

        if(email.equals("") || password.equals(""))
            return null;

        Optional<User> user = userRepository.findAll().stream().filter(u -> {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
            return false;
        }).findFirst();
        return user.orElse(null);
    }

    @GetMapping("/register")
    public User registerPage(@RequestParam("email") String email,
                             @RequestParam("firstName") String fname,
                             @RequestParam("lastName") String lname,
                             @RequestParam("password") String password,
                             @RequestParam("confPassword") String confPassword,
                             ModelAndView model) {

        if (fname.equals("") || lname.equals("") || password.equals("")) {
            return null;
        }

        if (!email.contains("@trainup.com") || !confPassword.equals(password)) {
            return null;
        }

        ///Index of the @ in the string
        int atIndex = email.indexOf("@");


        ///If the email the user has entered has more than just a @ return null
        if (email.lastIndexOf("@") != atIndex)
            return null;

        ///String before the @ in an email
        String beforeAt = email.substring(0, atIndex);

        ///The body of the email before the @ should containt a "."
        if (!beforeAt.contains("."))
            return null;

        ///If the body of the email before the @ contains anything else than letters and the "." return null
        if (!beforeAt.matches(".*[a-zA-Z.]+."))
            return null;

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setType("user");
        newUser.setFirstName(fname);
        newUser.setLastName(lname);
        newUser.setPassword(password);

        userRepository.saveAndFlush(newUser);
        return newUser;
    }

}