package com.cs.rest.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.mongo.model.LoginStatus;
import com.cs.mongo.repository.LoginStatusRepository;
import com.cs.request.models.LoginParams;
import com.cs.utility.DateUtility;

@Service
public class LoginStatusServices {

	@Autowired
	private LoginStatusRepository loginStatusRepository;

	public void addNewSession(LoginParams loginParams, StringBuilder encryptedsession) {
		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setUserName(loginParams.getUsername());
		loginStatus.setPassword(loginParams.getPassword());
		loginStatus.setSession_id(encryptedsession.toString());
		loginStatus.setStatus("Valid");
		try {
			loginStatus.setCreatedDate(DateUtility.getDateWithTimeZone());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		loginStatusRepository.save(loginStatus);
	}

	public LoginStatus getAllSession(String session_id) {
		int index = session_id.lastIndexOf("@");
		String userName = session_id.substring(index+1);
		System.out.println(userName);
		return loginStatusRepository.findByUserName(userName);
	}

	public void removeSession(String session_id) {
		int index = session_id.lastIndexOf("@");
		String userName = session_id.substring(index+1);
		System.out.println(userName);
		loginStatusRepository.delete(userName);		
	}

	public void updateSession(String session_id) {
		 LoginStatus loginCurrentStatus = getAllSession( session_id);
		 try {
			loginCurrentStatus.setCreatedDate(DateUtility.getDateWithTimeZone());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		 loginStatusRepository.save(loginCurrentStatus);
	}
	
	
}
