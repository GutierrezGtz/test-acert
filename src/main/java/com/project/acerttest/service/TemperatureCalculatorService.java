package com.project.acerttest.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.project.acerttest.model.Converted;
import com.project.acerttest.model.ThermometricScales;
import com.project.acerttest.protocol.BadRequestException;
import com.project.acerttest.protocol.ConvertedReq;

@Service
public class TemperatureCalculatorService {

	public Converted convert(ConvertedReq req) {
		Converted c = new Converted();

		if (req.getOrigin().equals(ThermometricScales.CELSIUS.getDesc())) {
			c.setConvertedValue(roundTwoDecimals(req.getOriginValue() * 1.8 + 32));
			c.setDestiny(ThermometricScales.FAHRENHEIT.getDesc());
		} else if (req.getOrigin().equals(ThermometricScales.FAHRENHEIT.getDesc())) {
			c.setConvertedValue(roundTwoDecimals((req.getOriginValue() - 32) / 1.8));
			c.setDestiny(ThermometricScales.CELSIUS.getDesc());
		} else {
			throw new BadRequestException("Bad Request");
		}
		c.setOriginValue(req.getOriginValue());
		c.setOrigin(req.getOrigin());

		return c;
	}
	
	public double roundTwoDecimals(double d) {
	    //DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Math.round(d*1e2)/1e2;
	   // return Double.parseDouble(twoDForm.format(d));
	}
}
