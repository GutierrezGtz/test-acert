package com.project.acerttest.service;

import org.springframework.stereotype.Service;

import com.project.acerttest.model.Converted;
import com.project.acerttest.protocol.BadRequestException;
import com.project.acerttest.protocol.ConvertedReq;


@Service
public class TemperatureCalculatorService {

	public Converted convert(ConvertedReq req) {
		Converted c = new Converted();
		
		if(req.getOrigin().equals("celsius")) {
			c.setConvertedValue(req.getOriginValue() + 273);
			c.setDestiny("fahrenheit");
		}else if(req.getOrigin().equals("fahrenheit")) {
			c.setConvertedValue(req.getOriginValue() - 273);
			c.setDestiny("celsius");
		}else {
			throw new BadRequestException("Bad Request");
		}
		c.setOriginValue(req.getOriginValue());
		c.setOrigin(req.getOrigin());
		
		return c;
		
	}

}
