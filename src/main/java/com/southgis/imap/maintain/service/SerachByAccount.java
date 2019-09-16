package com.southgis.imap.maintain.service;

import java.util.Date;
import java.util.List;

import com.southgis.imap.maintain.entity.SmsInfo;

public interface SerachByAccount {
	//条件查询
	List<SmsInfo> searchByaccount(String account);

	//根据条件进行分组查询
	List<SmsInfo> findByCompany(Date createtime);
	
}
