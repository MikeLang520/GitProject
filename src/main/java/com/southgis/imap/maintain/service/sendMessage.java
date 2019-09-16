package com.southgis.imap.maintain.service;

import java.util.Date;
import java.util.List;

import com.southgis.imap.maintain.entity.SendMessage;

public interface sendMessage {
	
	
	void add(SendMessage sendMessage);
	//1.发送总数top10
	List<SendMessage> groupBySend(Date insertDate);

	//2.发送失败总数top10
	List<SendMessage> SendMessageFail(Date insertDate);
	
	//3.发送前二十
	List<SendMessage> SendTop(Date insertDate);
	
	//4.查询总数
	Integer FindCount(Date insertDate);
	
	//5.根据时间查询所有
	Integer FindAllBytime(Date insertDate);
	
	//6.根据指定时间查询所有发送失败的
	Integer FindByInsertFail(Date insertDate);
}
