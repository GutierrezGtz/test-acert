package com.project.acerttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.project.acerttest.model.Converted;
import com.project.acerttest.protocol.ConvertedReq;

public class ControllerTest extends AbstractTest{
	   
	 @Test
	   public void getList() throws Exception {
	      String uri = "/calculator/list";
	      super.setUp();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Converted[] convertedlist = super.mapFromJson(content, Converted[].class);
	      assertTrue(convertedlist.length > 0);
	   }
	 
	 @Test
	   public void postConverted() throws Exception {
	      String uri = "/calculator/convert";
	      ConvertedReq req = new ConvertedReq();
	      req.setOrigin("celsius");
	      req.setOriginValue(100);
	      String inputJson = super.mapToJson(req);
	      super.setUp();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "{\"id\":6,\"origin\":\"celsius\",\"destiny\":\"fahrenheit\",\"originValue\":100.0,\"convertedValue\":212.0}");
	   }
	 
	 @Test
	   public void postConvertedF() throws Exception {
	      String uri = "/calculator/convert";
	      ConvertedReq req = new ConvertedReq();
	      req.setOrigin("fahrenheit");
	      req.setOriginValue(212);
	      String inputJson = super.mapToJson(req);
	      super.setUp();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "{\"id\":7,\"origin\":\"fahrenheit\",\"destiny\":\"celsius\",\"originValue\":212.0,\"convertedValue\":100.0}");
	   }
}
