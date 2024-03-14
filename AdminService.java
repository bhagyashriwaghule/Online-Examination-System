package com.tka.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.AdminDao;


import com.tka.entity.User;
@Service
public class AdminService {
	
	@Autowired
AdminDao dao;
	public boolean validate(User user)
	{
		String dbpassword=dao.getPassword(user.getUsername());
				if(dbpassword.equals(user.getPassword()))
				{
					return true;
					
				}
				else
				{
					return false;
				}
	}
}