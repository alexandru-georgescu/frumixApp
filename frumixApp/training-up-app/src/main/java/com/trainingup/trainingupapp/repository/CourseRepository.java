package com.trainingup.trainingupapp.repository;

import com.trainingup.trainingupapp.tables.CourseDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseDB, Long> {
}