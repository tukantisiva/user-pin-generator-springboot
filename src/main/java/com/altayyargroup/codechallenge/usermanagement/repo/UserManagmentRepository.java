package com.altayyargroup.codechallenge.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altayyargroup.codechallenge.usermanagement.entity.User;

public interface UserManagmentRepository extends JpaRepository<User, String> {

}
