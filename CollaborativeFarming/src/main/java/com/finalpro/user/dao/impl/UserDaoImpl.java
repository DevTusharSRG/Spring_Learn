package com.finalpro.user.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finalpro.user.dao.UserDao;
import com.finalpro.user.model.User;

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
	
	@Transactional
	@Override
	public User findByEmailId(String email) {
		String hql = "from User where email = :email";
		return sessionFactory.getCurrentSession()
				.createQuery(hql  ,User.class)
				.setParameter("email", email)
				.uniqueResult();
	}
}