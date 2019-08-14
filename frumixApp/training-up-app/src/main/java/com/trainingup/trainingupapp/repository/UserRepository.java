package com.trainingup.trainingupapp.repository;

import com.trainingup.trainingupapp.tables.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDB, String> {
}

