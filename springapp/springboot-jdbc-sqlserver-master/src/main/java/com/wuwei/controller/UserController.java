package com.wuwei.controller;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.bind.annotation.*;
import com.wuwei.entity.Result;
import com.wuwei.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService hservice;
	
@GetMapping("/All")
public Result getUser() {
	System.out.println("GetAllUsers controllerr");
	return hservice.getAllUsers();
}

@PostMapping("/byId")
public Result getUserById(@RequestParam int id) {
	System.out.println("getUserById controllerr");
	return hservice.getUserById(id);
}

@PostMapping("/byEmail")
public Result getUserByEmail(@RequestParam String email) {
	System.out.println("getUserByEmail controllerr");
	return hservice.getUserByEmail(email);
}

@PostMapping("/")
	public Result createUser(@RequestBody String email, @RequestBody String password) {

		System.out.println("createUser controllerr");
			return hservice.createUser(email, password);
		
	}
	
	@PutMapping("/")
	public Result updateUser(@RequestBody String email,@RequestBody String password) {
		System.out.println("updateUser controllerr");
return hservice.updateUser(email, password);
	}
	
	@DeleteMapping("/all")
	public Result deleteAllUsers() {

		System.out.println("deleteAllUsers controllerr");	
		return hservice.deleteAllUsers();
	}

	@DeleteMapping("/")
	public Result deleteUser(@RequestParam String email) {

		System.out.println("DeleteUser controllerr");	
		return hservice.deleteUser(email);
	}
	
}
