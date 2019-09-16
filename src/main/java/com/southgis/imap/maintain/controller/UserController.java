package com.southgis.imap.maintain.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southgis.imap.maintain.dto.JsonResult;
import com.southgis.imap.maintain.dto.JsonTime;
import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/*添加功能*/
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(SmsInfo smsinfo) {
		String result = this.userService.addUser(smsinfo);
		return new JsonResult("result", 0,result);
	}
	
	/*删除功能*/
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Object deleteUser(Integer id) {
		this.userService.deleteUser(id);
		return new JsonResult("success",0);
	}
	
	/*修改功能*/
	@RequestMapping("/editUser")
	@ResponseBody
	public Object editUser(Integer id) {
		SmsInfo smsinfo = this.userService.findById(id);
		return new JsonResult("success",0,smsinfo);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(SmsInfo smsinfo) {
		this.userService.updateUser(smsinfo);
		return new JsonResult("success",0);
	}
	
	/*查询功能*/
	@RequestMapping("/findUserAll")
	@ResponseBody
	public Object findUser() {
		List<SmsInfo> list = this.userService.findUser();
		return new JsonResult("success",0,list);
	}
	
	/*根据时间查询*/
//	@RequestMapping("/time")
//	public String findBycreatetime(Integer type,Model model) throws ParseException {
//		Calendar calendar = Calendar.getInstance();
//		switch (type) {
//		case 1:
//			calendar.add(Calendar.YEAR, -1);
//			break;
//		case 2:
//			calendar.add(Calendar.MONTH, -6);
//			break;
//		case 3:
//			calendar.add(Calendar.MONTH, -1);
//			break;
//		case 4:
//			calendar.add(Calendar.DATE, -7);
//			break;
//		default:
//			break;
//		}
//// 		String dateString = "2019-8-28 15:30";
////		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
////		Date date = format.parse(dateString);
//		List<SmsInfo> list = this.userService.selectByCreatetime(calendar.getTime());
////		List<SmsInfo> list2 = this.userService.selectByCreatetime(date);
////		System.out.println(list2);
//		model.addAttribute("list", list);
//		int count = list.size();
//		model.addAttribute("count", count);
//		model.addAttribute("type", type);
//		return "show";
//		
//	}
	
	//根据指定时间查询
	@RequestMapping("/datetime")
	@ResponseBody
	public Object findBycreatetime(String time) throws ParseException {
 		String dateString = time;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = format.parse(dateString);
		List<SmsInfo> list = this.userService.selectByCreatetime(date);
		int count = list.size();
		return new JsonTime(0,list,count);
		
	}

}
