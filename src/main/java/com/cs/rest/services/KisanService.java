package com.cs.rest.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.cs.mongo.model.Kisan;
import com.cs.mongo.repository.KisanRepository;

@Service
public class KisanService {
	

	Kisan kisan;
	@Autowired
	KisanRepository kisanRepository;

	public String addKisan(Kisan nweKisan) {
		
		if(StringUtils.isEmpty(nweKisan.getSlipNumber()) || nweKisan.getSlipNumber().equals("slipNumber"))
			return "Invalid Slip Number";

		kisan  = new Kisan();
		kisan.setCreatedDate(new Date());
		kisan.setLastModifiedDate(new Date());
		kisan.setMaintainedBy(nweKisan.getMaintainedBy());
		kisan.setSlipNumber(nweKisan.getSlipNumber());
		kisan.setKisanName(nweKisan.getKisanName());
		kisan.setFatherName(nweKisan.getFatherName());
		kisan.setLotNumber(nweKisan.getLotNumber());
		kisan.setPickupPrice(nweKisan.getPickupPrice());
		kisan.setDropPrice(nweKisan.getDropPrice());
		kisan.setMobile(nweKisan.getMobile());
		kisan.setNoOfPacket(nweKisan.getNoOfPacket());
		kisan.setAddress(nweKisan.getAddress());
		kisanRepository.save(kisan);
		
		return "Kisan Added Successfully";
	}
	

	
	
}
