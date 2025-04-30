package com.GovernmentSchemes.user.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GovernmentSchemes.user.dao.UserDao;
import com.GovernmentSchemes.user.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<User> getAllUsers (){
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
	}
	
	@Transactional
    public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
	
	 // Get user by ID
	@Transactional
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    // Update existing user
	@Transactional
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    // Delete user
	@Transactional
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }
}