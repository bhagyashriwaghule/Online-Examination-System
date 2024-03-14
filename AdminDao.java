package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;
@Repository
public class AdminDao {
	@Autowired
	SessionFactory factory;
		public String getPassword(String username) {
			Session session=factory.openSession();
			User userFromDB=session.get(User.class, username);
			return userFromDB.getPassword();
		}

	
}
