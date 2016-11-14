package com.cs.rest.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.mongo.model.AdminConstants;
import com.cs.mongo.repository.AdminConstantsRepository;

@Service
public class AdminConstantsServices {
	
	@Autowired
	AdminConstantsRepository adminConstantsRepository;
	@Autowired
	TransactionsService transactionsService;

	public AdminConstants getAdminConstant(String year) {
		return adminConstantsRepository.findByYear(year);
	}

	public String setAdminConstant(AdminConstants adminConstants) {
		adminConstantsRepository.save(adminConstants);
		return "Admin Constant Successfully Saved";
	}

	public Map<String, AdminConstants> getAllAdminConstant() {
		
		List<AdminConstants> allApplicationConstant = adminConstantsRepository.findAll();
		Map<String, AdminConstants> yearWiseApplicatinconstat = new HashMap<>();
		
		for (AdminConstants adminConstants : allApplicationConstant) {
			yearWiseApplicatinconstat.put(adminConstants.getYear(), adminConstants);
		}
		return yearWiseApplicatinconstat;
	}

	public String getpacketInToday(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getpacketRemainingInStorage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getrevenueForToday(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getpacketInColdStorage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getpacketOutToday(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
