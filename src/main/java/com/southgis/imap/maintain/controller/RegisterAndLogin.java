package com.southgis.imap.maintain.controller;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southgis.imap.maintain.service.LoginService;

@Controller
@RequestMapping("/users")
public class RegisterAndLogin {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Object Login(@Param("userName") String userName, @Param("pwd") String pwd, HttpSession session ) {
		Object result = this.loginService.login(userName, pwd);
		session.setAttribute("account", result);
		return result;
	}
}
