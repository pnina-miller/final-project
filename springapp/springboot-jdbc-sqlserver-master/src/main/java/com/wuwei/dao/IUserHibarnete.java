package com.wuwei.dao;



import java.util.List;

import com.wuwei.entity.User;

public interface IUserHibarnete {
	
	public int updateUser(User user);
	
	public List<User> getUser(String name, String password);
	
	public List<User> getAllUsers();
	
	public int deleteUser(String email, String password);
}