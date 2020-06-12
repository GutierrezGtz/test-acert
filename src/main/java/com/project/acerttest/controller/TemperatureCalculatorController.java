package com.project.acerttest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.acerttest.model.Converted;
import com.project.acerttest.protocol.ConvertedReq;
import com.project.acerttest.repository.ConvertedRepository;
import com.project.acerttest.service.TemperatureCalculatorService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({ "/calculator" })
public class TemperatureCalculatorController {

	@Autowired
	private ConvertedRepository repository;
	
	@Autowired
	private TemperatureCalculatorService service;

	@GetMapping(path = "/list")
	public List findAll() {
		return repository.findAll();
	}
	
	/**
	 * converte um valor de uma escala termometrica
	 * valores aceitos para origin { celsius, fahrenheit }
	 * @param ConvertedReq
	 */
	@ApiResponses(value = {
		    @ApiResponse(code = 400, message = "Bad Request"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PostMapping(path = "/convert")
	public Converted convert(@RequestBody ConvertedReq req){
		return repository.save(service.convert(req));
	}

}