package com.southgis.imap.maintain.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southgis.imap.maintain.entity.SendMessage;
import com.southgis.imap.maintain.mapper.SendMessageMapper;
import com.southgis.imap.maintain.service.sendMessage;
@Service
@Transactional
public class SendMessageImpl implements sendMessage {

	@Autowired
	private SendMessageMapper sendMessageMapper;
	
	@Override
	public void add(SendMessage sendMessage) {
		sendMessage.setInsertDate(Calendar.getInstance().getTime());
		this.sendMessageMapper.add(sendMessage);
	}

	//1.发送总数top10
	@Override
	public List<SendMessage> groupBySend(Date insertDate) {
		return this.sendMessageMapper.GroupBySend(insertDate);
	}

	//2.发送失败总数top10
	@Override
	public List<SendMessage> SendMessageFail(Date insertDate) {
		return this.sendMessageMapper.SendFail(insertDate);
	}

	//3.发送前二十
	@Override
	public List<SendMessage> SendTop(Date insertDate) {
		return this.sendMessageMapper.sendTop(insertDate);
	}

	//4.查询总数
	@Override
	public Integer FindCount(Date insertDate) {
		return this.sendMessageMapper.findCount(insertDate);
	}
	
	//5.根据指定时间段查询所有
	@Override
	public Integer FindAllBytime(Date insertDate) {
		return this.sendMessageMapper.findAllBytime(insertDate);
	}

	//6.根据指定时间段查询所有发送失败的信息
	@Override
	public Integer FindByInsertFail(Date insertDate) {
		return this.sendMessageMapper.findByInsertFail(insertDate);
	}
	
	


}
