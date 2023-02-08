package com.hodoos.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.memo.common.EncryptUtils;
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
		
		// 암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, userName, email, birthday);
	}
}
