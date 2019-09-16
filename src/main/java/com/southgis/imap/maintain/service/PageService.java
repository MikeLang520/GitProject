package com.southgis.imap.maintain.service;

import java.util.List;


import com.southgis.imap.maintain.entity.SmsInfo;

public interface PageService {

//	 List<SmsInfo> queryStudentsByArray(int currPage, int pageSize);
	 
	 //Mybatis数据库实现
	 List<SmsInfo> queryBySql(int currPage, int pageSize);
}
