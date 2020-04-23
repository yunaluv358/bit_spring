package com.example.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private Map<String, Object> map;// 앞에 타겟 뒤에는 value

	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		if (map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if (user.getPasswd().equals(u.getPasswd())) {
				return u;
			}
		}
		return returnUser;

	}

	@Override
	public User detail(String userid) {
		return (User) map.get(userid);
	}

}
