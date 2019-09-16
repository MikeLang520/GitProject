package com.southgis.imap.maintain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.mapper.PageBySql;
import com.southgis.imap.maintain.service.PageService;

@Service
@Transactional
public class PageServiceImpl implements PageService {

//	@Autowired
//	private PageMapper pageMapper;
	
	@Autowired
	private PageBySql pageBySql;

//	@Override
//	public List<SmsInfo> queryStudentsByArray(int currPage, int pageSize) {
//		// 查询全部数据
//		List<SmsInfo> smsInfo = pageMapper.queryStudentsByArray();
//		int count = smsInfo.size();
//		int count1 = currPage * pageSize;
//		int count2 = 8 - (count1-count);
//		if (count1 > count) {
//			int firstIndex = (currPage - 1) * pageSize;
//			// 到第几条数据结束
//			int lastIndex = (currPage-1) * pageSize + count2;
//			return smsInfo.subList(firstIndex, lastIndex); // 直接在list中截取
//		} else {
//			// 从第几条数据开始
//			int firstIndex = (currPage - 1) * pageSize;
//			// 到第几条数据结束
//			int lastIndex = currPage * pageSize;
//			return smsInfo.subList(firstIndex, lastIndex); // 直接在list中截取
//		}
//	}

	@Override
	public List<SmsInfo> queryBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("currIndex", (currPage - 1) * pageSize);
		data.put("pageSize", pageSize);
		return this.pageBySql.queryBySql(data);
	}
}