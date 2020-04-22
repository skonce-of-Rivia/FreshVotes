package com.freshvotes.service;


import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {

	
	@Test
	public void generateEncryptedPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "0000";
		String encoderPassword = encoder.encode(rawPassword);
		
		System.out.println(encoderPassword);
		
		assertThat(rawPassword, not(encoderPassword));
	}

}
