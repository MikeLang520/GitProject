package com.southgis.imap.maintain.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.southgis.imap.maintain.dto.JsonResult;
import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.service.SerachByAccount;

@Controller
@RequestMapping("users")
public class SearchController {
	@Autowired
	private SerachByAccount serachByAccount;
	
	/*根据用户的账户进行条件查询*/
	@RequestMapping("/search")
	@ResponseBody
	public Object Search(String account){
		List<SmsInfo> list = this.serachByAccount.searchByaccount(account);
		int count = list.size();
		System.out.println(list);
		System.out.println(count);
		return new JsonResult("success",0,list);
		
	}

}
