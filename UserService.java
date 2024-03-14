package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.UserDao;
import com.tka.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public List<User>getAllUsers(){
		return dao.getallUsers();
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return dao.getUser(username);
	}
	public void deleteUser(String username)
	{
		dao.deleteUser(username);
	}
}
