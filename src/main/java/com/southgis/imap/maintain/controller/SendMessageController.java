package com.southgis.imap.maintain.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southgis.imap.maintain.dto.JsonStatistics;
import com.southgis.imap.maintain.entity.SendMessage;
import com.southgis.imap.maintain.service.sendMessage;

@Controller
@RequestMapping("/users")
public class SendMessageController {

	@Autowired
	private sendMessage sendmessage;
	
	@RequestMapping("/groupbysend")
	@ResponseBody
	public Object groupbySend(@RequestParam(defaultValue = "1") Integer type) {
		Calendar calendar = Calendar.getInstance();
		switch (type) {
		case 1:
			calendar.add(Calendar.YEAR, -1);
			break;
		case 2:
			calendar.add(Calendar.MONTH, -6);
			break;
		case 3:
			calendar.add(Calendar.MONTH, -1);
			break;
		case 4:
			calendar.add(Calendar.DATE, -7);
			break;
		default:
			break;
		}
		/* 1.发送总数top10 */
		List<SendMessage> list = this.sendmessage.groupBySend(calendar.getTime());

		/* 2.发送总数失败top10 */
		List<SendMessage> list2 = this.sendmessage.SendMessageFail(calendar.getTime());

		/* 3.发送前二十 */
		List<SendMessage> list3 = this.sendmessage.SendTop(calendar.getTime());
		// 获取数据库中所有指定时间发送信息的总数
		Integer Count = this.sendmessage.FindCount(calendar.getTime());
		int sum = 0;
		for (int i = 0; i < list3.size(); i++) {
			SendMessage send = list3.get(i);
			int sum2 = send.getId();
			sum += sum2;
		}
		int other = Count - sum;

		// 4.指定时间发送总数和发送失败
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		Calendar calendar2 = Calendar.getInstance();
		for (int i = 0; i < 24 / 3; i++) {
			calendar2.add(Calendar.DATE, -1);
			Integer count = this.sendmessage.FindAllBytime(calendar2.getTime());
			Integer count2 = this.sendmessage.FindByInsertFail(calendar2.getTime());
			array1.add(count);
			array2.add(count2);
		}
		return new JsonStatistics(0, list, list2, other, list3, array1, array2);
	}
}
