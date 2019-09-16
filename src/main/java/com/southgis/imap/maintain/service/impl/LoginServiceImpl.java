package com.southgis.imap.maintain.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southgis.imap.maintain.dto.JsonResult;
import com.southgis.imap.maintain.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Override
	public Object login(String userName, String pwd) {
		Object str;
		if(userName.equals("Mike")) {
			if(pwd.equals("123456")) {
				str = new JsonResult("success", 0);
			}
			else {
				str = new JsonResult("fail",1);
			} 
		}else {
			str = new JsonResult("fail",1);
		}
		return str;
	}
}
