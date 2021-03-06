package com.cs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.request.models.LoginParams;
import com.cs.request.models.LoginResponse;
import com.cs.rest.services.SessionManagementService;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	SessionManagementService sessionMangement;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse>  adminLogin (@RequestBody LoginParams lp) 
					throws MessagingException {
		LoginResponse responseParams = sessionMangement.validateUser(lp);
		  HttpHeaders httpHeaders = new HttpHeaders();
		  return new ResponseEntity<LoginResponse>(responseParams, httpHeaders,HttpStatus.OK);
	}
}
