package com.altayyargroup.codechallenge.usermanagement.service;

import java.util.List;

import com.altayyargroup.codechallenge.usermanagement.dto.Response;
import com.altayyargroup.codechallenge.usermanagement.entity.User;

public interface UserManagementService {

	public List<User> findAll();

	public Response generatePin(String userID);

	public Response validatePin(String userId, String pin);

}
