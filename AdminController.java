package com.tka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.User;
import com.tka.service.AdminService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService service;
	@RequestMapping("validateadmin")
	public ResponseEntity<Boolean>validateadmin(@RequestBody User user)
	{
		boolean answer =service.validate(user);
		if(answer)
		{
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
	}
}

	