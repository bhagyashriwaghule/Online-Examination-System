package com.tka.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Answer;
import com.tka.entity.User;
import com.tka.service.LoginService;


@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {
	@Autowired
	LoginService service;
	
 static HttpSession httpSession;
 //{"username":"x","password":"y"}
	@RequestMapping("validate")
	public ResponseEntity<Boolean>validate(@RequestBody User user,HttpServletRequest request)
	{
		httpSession=request.getSession();
		boolean answer=service.validate(user);
		if(answer)
		{
			httpSession.setAttribute("score", 0);
			
			HashMap<Integer, Answer>map=new HashMap<>();
			
			httpSession.setAttribute("submittedDetails", map);
			
			httpSession.setAttribute("questionIndex", 0);
			
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
	}
	
}
