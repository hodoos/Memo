package com.hodoos.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.memo.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	public int addUser(
			String loginId
			, String password
			, String userName
			, String email
			, String birthday) {
		
		return userDAO.insertUser(loginId, password, userName, email, birthday);
	}
}
