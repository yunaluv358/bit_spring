package com.example.web.user;

public interface UserService {

	void add(User user);

	int count();
	
	public User login(User user);
	
	public User detail(String userid); //얘는 그냥 먼저 써줌

	

}
