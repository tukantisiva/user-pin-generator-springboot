package com.altayyargroup.codechallenge.usermanagement.service.impl;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altayyargroup.codechallenge.usermanagement.dto.Response;
import com.altayyargroup.codechallenge.usermanagement.entity.User;
import com.altayyargroup.codechallenge.usermanagement.repo.UserManagementQueryRepository;
import com.altayyargroup.codechallenge.usermanagement.repo.UserManagmentRepository;
import com.altayyargroup.codechallenge.usermanagement.service.UserManagementService;
import com.altayyargroup.codechallenge.usermanagement.util.ApplicationContants;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagmentRepository userManagmentRepository;

	@Autowired
	private UserManagementQueryRepository userManagementQueryRepository;

	@Override
	public List<User> findAll() {
		return userManagementQueryRepository.findAll();
	}

	/*
	 * Generates a PIN for a user and store this code in H2 Database
	 * 
	 * @param userID
	 */
	@Override
	public Response generatePin(String userID) {
		Optional<String> optionUserID = Optional.ofNullable(userID);
		if (optionUserID.isPresent()) {
			User user = new User();
			user.setUserID(userID);
			user.setPin(getAlphaNumeric(ApplicationContants.GENETED_PIN_LENGTH));
			try {
				if (!userManagmentRepository.exists(user.getUserID())) {
					userManagmentRepository.save(user);
				} else {
					return new Response(ApplicationContants.RESULT_CODE_EXISTING,
							ApplicationContants.RESULT_CODE_EXISTING_MSG, "");
				}
			} catch (Exception e) {
				return new Response(ApplicationContants.RESULT_CODE_ERROR, ApplicationContants.RESULT_CODE_EXISTING_MSG,
						"");
			}
			return new Response(ApplicationContants.RESULT_CODE_SUCCESS, ApplicationContants.RESULT_CODE_SUCCESS_MSG,
					"");
		} else {
			return new Response(ApplicationContants.RESULT_CODE_ERROR, ApplicationContants.RESULT_CODE_USERID_NULLMSG,
					"");
		}
	}

	/*
	 * Generates Alpha Numeric PIN of length @len
	 * 
	 * @param len
	 */
	public String getAlphaNumeric(int len) {
		char[] ch = ApplicationContants.GENETED_ALPHANUMERIC_SET.toCharArray();
		char[] c = new char[len];
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < len; i++) {
			c[i] = ch[random.nextInt(ch.length)];
		}
		return new String(c);
	}

	/*
	 * validates the PIN for the User is valid
	 * 
	 * @param userId
	 * 
	 * @param pin
	 */
	@Override
	public Response validatePin(String userId, String pin) {
		try {
			List<User> users = userManagementQueryRepository.validatePinByUserID(userId, pin);
			if (users.isEmpty()) {
				return new Response(ApplicationContants.RESULT_CODE_SUCCESS, "",
						ApplicationContants.RESULT_CODE_INVALID_MSG);
			} else {
				return new Response(ApplicationContants.RESULT_CODE_SUCCESS, "",
						ApplicationContants.RESULT_CODE_VALID_MSG);
			}
		} catch (Exception e) {
			return new Response(ApplicationContants.RESULT_CODE_ERROR, "", ApplicationContants.RESULT_CODE_ERROR_MSG);
		}

	}

}
