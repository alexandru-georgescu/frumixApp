package com.trainingup.trainingupapp.tables;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EnableAutoConfiguration
@Table(name="USER")
public class User {

    @Id
    private String email;
    private String type;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Course> courses;

    public List<Course> getCourses() {
        if (courses == null) {
            return new ArrayList<Course>();
        }
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
