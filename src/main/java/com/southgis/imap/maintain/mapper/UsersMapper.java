package com.southgis.imap.maintain.mapper;

import java.util.Date;
import java.util.List;

import com.southgis.imap.maintain.entity.SmsInfo;

public interface UsersMapper {
	
	//根据用户创建时间查询
	List<SmsInfo> selectSmsInfoByCreatetime(Date createtime);
	
	//根据用户账户查询
	List<SmsInfo> searchByAccount(String Caccount);

	//根据时间进行分组查询
	List<SmsInfo> groupByCompany(Date createtime);
	
}
