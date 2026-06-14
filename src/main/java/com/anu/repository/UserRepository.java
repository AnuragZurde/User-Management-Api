package com.anu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
