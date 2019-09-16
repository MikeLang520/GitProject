package com.southgis.imap.maintain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.mapper.UsersMapper;
import com.southgis.imap.maintain.service.SerachByAccount;
@Service
@Transactional
public class SearchByAccountImpl implements SerachByAccount {
	
	@Autowired
	private UsersMapper userMapper;

	@Override
	public List<SmsInfo> searchByaccount(String account) {
		
		return this.userMapper.searchByAccount(account);
	}

	@Override
	public List<SmsInfo> findByCompany(Date createtime) {
			
		return this.userMapper.groupByCompany(createtime);
	}	

}
