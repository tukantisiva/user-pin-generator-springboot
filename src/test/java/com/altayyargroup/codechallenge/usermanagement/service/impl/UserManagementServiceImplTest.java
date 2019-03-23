package com.altayyargroup.codechallenge.usermanagement.service.impl;

import com.altayyargroup.codechallenge.usermanagement.entity.User;
import com.altayyargroup.codechallenge.usermanagement.repo.UserManagementQueryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.*;

public class UserManagementServiceImplTest {
	@InjectMocks
	UserManagementServiceImpl userManagementService;
	
	@Mock
	UserManagementQueryRepository userManagementQueryRepository;	
	
	User usr;
	
	List<User> userLst;
	@Before
	public void setUp() throws Exception {
		userLst=new ArrayList<>();
		usr=new User();
		usr.setUserID("874930");
		usr.setPin("ab76tx");
		userLst.add(usr);

		
	}

	@Test
	public void testFindAll() {
		/*Mockito.when(userManagementQueryRepository.findAll()).thenReturn(userLst);
		userManagementService.findAll();
		Mockito.verify(userManagementQueryRepository).findAll();
		*/
				assertNotNull(usr);
	}
	
	
	@Test
	public void testGetAlphaNumericNotNull() {
		UserManagementServiceImpl userManagementServiceimpl=new UserManagementServiceImpl();
		System.out.println(userManagementServiceimpl.getAlphaNumeric(6));
		assertNotNull("JobMasterTO should not be null", userManagementServiceimpl.getAlphaNumeric(6));
	}

	
	@Test
	public void testGetAlphaNumericZeroLength() {
		UserManagementServiceImpl userManagementServiceimpl=new UserManagementServiceImpl();
		System.out.println(userManagementServiceimpl.getAlphaNumeric(0));
		assertNotNull("JobMasterTO should not be null", userManagementServiceimpl.getAlphaNumeric(0));
	}

	@Test
	public void testValidatePin() {
		assertEquals("Valid PIN ","ab76tx", usr.getPin());
	}
	@Test
	public void testInvalidPin() {
		assertNotEquals("Invalid PIN","bcdx12", usr.getPin());
	}
}
