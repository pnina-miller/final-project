package com.wuwei.controller;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wuwei.entity.Result;
import com.wuwei.service.ValueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/values")
public class ValuesController {

	@Resource
	private ValueService vService;

@GetMapping("/")
public Result getAllValues() {
	System.out.println("getAllValues controller");
	return vService.getAllValues();
	
}

@GetMapping("/byEmail")
public Result getValueByEmail(@RequestParam String email,@RequestParam String password) {
	System.out.println("getValueByEmail controller");
	return vService.getValueByEmail(email,password);
	
}

@PostMapping("/")
public Result CreateValue(@RequestBody LinkedHashMap value) throws Exception {
	System.out.println("CreateValue controller ");
	return vService.createValue(value);
	
}
	
}
