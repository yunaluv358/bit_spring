package com.example.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.util.Messenger;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	@PostMapping("/join")
	public Messenger join(@RequestBody User user) {
		int count = userService.count();
		System.out.println("현재 인원"+count);
		userService.add(user);
		System.out.println("추가된 인원"+userService.count());
		return (userService.count() == count + 1) ? Messenger.SUCCESS : Messenger.FAIL;

		 //() ? : 형식
	}
		@PostMapping("/login")
		public Map<String,Object> login(@RequestBody User user) {
			Map<String,Object> returnMap = new HashMap<>();
			User loginedUser = userService.login(user);
			if(loginedUser != null) {
				returnMap.put("user", loginedUser);
				returnMap.put("messenger", Messenger.SUCCESS);
				
			}else {
				returnMap.put("messenger", Messenger.FAIL);

			}
			return returnMap;
		
	}
}
