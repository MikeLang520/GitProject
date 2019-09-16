package com.southgis.imap.maintain.mapper;

import java.util.List;

import com.southgis.imap.maintain.entity.SmsInfo;

public interface CompanyMapper {
	
	/*添加功能*/
	void save(SmsInfo smsInfo);
	
	/*删除功能*/
	void deleteById(Integer id);
	
	/*更新功能*/
	/*根据id查询*/
	SmsInfo findById(Integer id);
	/*重写功能*/
	void saveAndFlush(SmsInfo smsInfo);
	
	/*查询功能*/
	List<SmsInfo> findAll();
	
}
