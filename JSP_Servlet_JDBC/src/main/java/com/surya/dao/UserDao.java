package com.surya.dao;


public interface UserDao {

	boolean addUser(User user);
	boolean isValidUser(String username, String password);
}