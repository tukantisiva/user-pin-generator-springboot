package com.altayyargroup.codechallenge.usermanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altayyargroup.codechallenge.usermanagement.dto.Response;
import com.altayyargroup.codechallenge.usermanagement.entity.User;
import com.altayyargroup.codechallenge.usermanagement.service.UserManagementService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/useradmin")
public class UserManagementController {
	@Autowired
	private UserManagementService userManagementService;

	/*
	 * Make an API that generates a verification code for a user and store this code
	 * in a database
	 */
	@RequestMapping(value = "/verification_code/{id}", produces = { "application/json", "application/xml",
			"application/csv" })
	public ResponseEntity<Response> generateVerficationCode(@PathVariable String id) {

		return new ResponseEntity<Response>(userManagementService.generatePin(id), HttpStatus.OK);
	}

	/*
	 * Make an API that generates a verification code for a user and store this code
	 * in a database
	 */
	@RequestMapping(value = "/verification_code/{id}/{code}", produces = { "application/json", "application/xml",
			"application/csv" })
	public ResponseEntity<Response> validateCodebyUserID(@PathVariable String id, @PathVariable String code) {
		return new ResponseEntity<Response>(userManagementService.validatePin(id, code), HttpStatus.OK);
	}

	/*
	 * Fetch all the User with respective PIN
	 */
	@RequestMapping(value = "/")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userManagementService.findAll(), HttpStatus.OK);
	}
}
