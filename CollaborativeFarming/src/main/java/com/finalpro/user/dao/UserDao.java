package com.finalpro.user.dao;

import java.util.List;

import com.finalpro.user.model.User;

public interface UserDao{
	public List<User> getAllUsers();
	public void save(User user);
	public User findByEmailId(String email);
}