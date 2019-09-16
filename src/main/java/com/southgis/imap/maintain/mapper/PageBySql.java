package com.southgis.imap.maintain.mapper;

import java.util.List;
import java.util.Map;


import com.southgis.imap.maintain.entity.SmsInfo;

public interface PageBySql {
	
	List<SmsInfo> queryBySql(Map<String,Object> data);
}
