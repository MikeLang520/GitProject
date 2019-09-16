package com.southgis.imap.maintain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southgis.imap.maintain.dto.JsonPage;
import com.southgis.imap.maintain.entity.SmsInfo;
import com.southgis.imap.maintain.mapper.PageMapper;
import com.southgis.imap.maintain.service.PageService;

@Controller
@RequestMapping("/users")
public class PageController {
	@Autowired
	private PageMapper pageMapper;

	@Autowired
	private PageService pageService;

	@RequestMapping("/Page")
	@ResponseBody
	public Object getStudentByArray(@RequestParam(defaultValue = "1") Integer id) {
		List<SmsInfo> list2 = this.pageMapper.queryStudentsByArray();
		int count = list2.size();
		int totalPages = count / 8 + 1;
		List<SmsInfo> list = this.pageService.queryBySql(id, 8);
		System.out.println(list);
		return new JsonPage("scuccess", 0, list,totalPages);
	}

}
