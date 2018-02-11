package com.javifast.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javifast.model.User;
import com.javifast.service.UserService;
import com.javifast.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.CONFLICT.value(),
									"Los campos obligatorios estan vacios");
		}
		this.userService.save(user);
		return new RestResponse(HttpStatus.CREATED.value(), "Operacion Exitosa");
	}
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		this.userService.findAll();
		return this.userService.findAll();
		
	}
	
	private boolean validate(User user) {
		boolean isValid = true;
		if(StringUtils.trimToNull(user.getFirstName())==null) {
			isValid = false;
		}
		if(StringUtils.trimToNull(user.getLastName())==null) {
			isValid = false;
		}
		return isValid;
		
	}
}
