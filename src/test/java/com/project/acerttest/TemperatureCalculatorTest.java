package com.project.acerttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.project.acerttest.model.Converted;
import com.project.acerttest.protocol.BadRequestException;
import com.project.acerttest.protocol.ConvertedReq;
import com.project.acerttest.service.TemperatureCalculatorService;

public class TemperatureCalculatorTest {
	
	private TemperatureCalculatorService service = new TemperatureCalculatorService();
	
	@Test
	public void testConvertCelsius() {
		ConvertedReq cr =  new ConvertedReq();
		cr.setOrigin("celsius");
		cr.setOriginValue(100);
		Converted c = service.convert(cr);
		
		assertEquals(373, c.getConvertedValue());
	}
	
	@Test
	public void testConvertFahrenheit() {
		ConvertedReq cr =  new ConvertedReq();
		cr.setOrigin("fahrenheit");
		cr.setOriginValue(300);
		Converted c = service.convert(cr);
		
		assertEquals(27, c.getConvertedValue());
	}
	
	@Test
	public void testConvertException() {
		ConvertedReq cr =  new ConvertedReq();
		cr.setOrigin("OutraUnidade");
		cr.setOriginValue(300);
		  Assertions.assertThrows(BadRequestException.class, () -> {
			  service.convert(cr);
			  });
	}
}
