package com.example.web.user;

public interface UserService {

	void add(User user);

	int count();
	
	public User detail(String userid);

	public User login(User user);

}
