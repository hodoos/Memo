package com.hodoos.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.memo.common.EncryptUtils;
import com.hodoos.memo.user.dao.UserDAO;
import com.hodoos.memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	public int addUser(
			String loginId
			, String password
			, String userName
			, String email
			, String birthDay) {
		
		// 암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, userName, email, birthDay);
	}
	
	public User getUser(String loginId, String password) {
		String encryptPassword2 = EncryptUtils.md5(password);
		
		return userDAO.selectUser(loginId, encryptPassword2);
	}
	
}
