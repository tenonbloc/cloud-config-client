package com.tenonbloc.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Sample controller to demonstrate 
 * the ways to use the external configuration properties
 */
@RestController
public class Controller {
	
	@Value("${com.tbloc.user.role}")
	private String roleV;
	@Value("${com.tbloc.user.profile}")
	private String profileV;

	@Autowired
	private Environment env;
	
	@GetMapping(value = "/whoami/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {
		String role = env.getProperty("com.tbloc.user.role");
		String profile = env.getProperty("com.tbloc.user.profile");
		return String.format("Hello! You're %s and you'll become a(n) %s...\nprofile %s .....from env variable profile is %s\n", username,roleV,profile,profileV);
	}

}
