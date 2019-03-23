package com.altayyargroup.codechallenge.usermanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.altayyargroup.codechallenge.usermanagement.entity.User;

public interface UserManagementQueryRepository extends Repository<User, Long> {
	@Query(value = "select u from User u where u.userID=:userID AND u.pin=:pin")
	List<User> validatePinByUserID(@Param("userID") String userID,@Param("pin") String pin);
	List<User> findAll();
}
