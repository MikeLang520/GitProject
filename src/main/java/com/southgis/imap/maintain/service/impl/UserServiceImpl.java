package com.southgis.imap.maintain.service.impl;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.mapper.CompanyMapper;
import com.southgis.imap.maintain.mapper.UsersMapper;
import com.southgis.imap.maintain.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired 
	private CompanyMapper companyMapper;

	/* 添加功能 */
	@Override
	public String addUser(SmsInfo smsinfo) {
		String str = "";
		smsinfo.setCreatetime(Calendar.getInstance().getTime());
		this.companyMapper.save(smsinfo);
		str = "redirect:/users/Page";
		return str;
	}

	/* 删除功能 */
	@Override
	public void deleteUser(Integer id) {
		this.companyMapper.deleteById(id);
	}

	/* 更新功能 */
	@Override
	public SmsInfo findById(Integer id) {
		return this.companyMapper.findById(id);
	}

	@Override
	public void updateUser(SmsInfo smsinfo) {
		this.companyMapper.saveAndFlush(smsinfo);
	}

	/* 查询功能 */
	@Override
	public List<SmsInfo> findUser() {
		return this.companyMapper.findAll();
	}

	/*MyBatis根据时间查找*/
	@Override
	public List<SmsInfo> selectByCreatetime(Date createtime) {
		
		return this.usersMapper.selectSmsInfoByCreatetime(createtime);
	}
	
	
	

}
