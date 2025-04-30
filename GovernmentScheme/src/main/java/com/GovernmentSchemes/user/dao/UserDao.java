package com.GovernmentSchemes.user.dao;

import java.util.List;

import com.GovernmentSchemes.user.model.User;

public interface UserDao{
	public List<User> getAllUsers();
	public void save(User user);
	public User getUserById(int id);
	public void updateUser(User user);
	public void deleteUser(User user);
}