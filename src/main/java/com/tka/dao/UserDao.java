package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;
@Repository
public class UserDao {
	@Autowired
	SessionFactory factory;
	public List<User>getallUsers()
	{
		Session session=factory.openSession();
		Query query=session.createQuery("from User");
		return query.list();
	}
	public User getUser(String username)
	{
		Session session=factory.openSession();
		Query query=session.createQuery("from User where username=:username");
		query.setParameter("username", username);
		return (User) query.list().get(0);
	}
	public void deleteUser(String username)
	{
		Session session=factory.openSession();
		Query<User> query=session.createQuery("delete from User where username=:username");
		query.setParameter("username", username);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		tx.commit();
	}
}
