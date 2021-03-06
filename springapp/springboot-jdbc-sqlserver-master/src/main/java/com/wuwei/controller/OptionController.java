package com.wuwei.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.wuwei.entity.Result;
import com.wuwei.service.OptionsService;

	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/option")
	public class OptionController {

		@Resource
		private OptionsService service;
		
		@GetMapping("/All")
		public Result getOptions() {
			System.out.println("GetAlloptions controllerr");
			return service.getOptions();
		}
		
		@GetMapping("/byName")
		public Result getOptionByName(@RequestParam String optionName) {
			System.out.println("getOptionByName controller option: "+optionName);
			return service.getByName(optionName);
		}
		
		@GetMapping("/byId")
		public Result getOptionById(@RequestParam int optionId) {
			System.out.println("getOptionById controller option: "+optionId);
			return service.getById(optionId);
		}
		
		@PostMapping("/Many")
		public Result createOptions(@RequestBody String[] optionsName) {
			System.out.println("createOptions controllerr");
			return service.createOptions(optionsName);
		}
		
		@PostMapping("/")
		public Result createOption(@RequestBody String optionName) {
			System.out.println("createOption controllerr");	
				return service.createOption(optionName);
		}
		
		@PutMapping("/")//not finished
		public Result updateOption(@RequestBody String optionName) {
			System.out.println("postoption controllerr");	
			return service.updateOption(optionName);
		}
				
		@DeleteMapping("/")
		public Result deleteOption(@RequestParam String option) {

			System.out.println("DeleteOption controller option:"+option);	
			return service.deleteOption(option);
		}
		
		@DeleteMapping("/all")
		public Result deleteAllOptions() {

			System.out.println("deleteAllOptions controller");	
			return service.deleteAllOptions();
		}
	}


