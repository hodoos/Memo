package com.hodoos.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hodoos.memo.user.bo.UserBO;

@RestController // @Controller + @ResponseBody
public class UserRestController {

	// 회원가입 API
	@Autowired
	private UserBO userBO;

	@PostMapping("/user/signup")
	public Map<String, String> signup(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("userName") String userName
			, @RequestParam("email") String email
			, @RequestParam("birthday") String birthday) {
		
		int count = userBO.addUser(loginId, password, userName, email, birthday);
		
		Map<String, String> result = new HashMap<>();
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
	}
	
}
