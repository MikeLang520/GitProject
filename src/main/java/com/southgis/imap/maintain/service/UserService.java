package com.southgis.imap.maintain.service;

import java.util.Date;
import java.util.List;

import com.southgis.imap.maintain.entity.SmsInfo;

public interface UserService {
	/*添加功能*/
	String addUser(SmsInfo smsinfo);
	
	/*删除功能*/
	void deleteUser(Integer CID);
	
	/*更新功能*/
	void updateUser(SmsInfo smsinfo);
	
	/*查询功能*/
	List<SmsInfo> findUser();
	
	SmsInfo findById(Integer id);
	
	/*根据时间来查找*/
	List<SmsInfo> selectByCreatetime(Date createtime);
	
	
}
