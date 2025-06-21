package com.twreturn.timeweightedreturn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twreturn.timeweightedreturn.User;

public interface UserRepository extends JpaRepository<User, Long> { }
