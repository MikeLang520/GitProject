package com.southgis.imap.maintain.mapper;

import java.util.Date;
import java.util.List;

import com.southgis.imap.maintain.entity.SendMessage;

public interface SendMessageMapper {

	void add(SendMessage sendMessage);
	
	//根据时间分组查询
	//1.发送总数top10
	List<SendMessage> GroupBySend(Date insertDate);
	
	//
//	List<SendMessage> GroupBySend(@Param("insertDate")Date insertDate,@Param("pip") Integer pip)
	
	//2.发送总数失败top10
	List<SendMessage> SendFail(Date insertDate);
	
	//3.发送总数前20及其他
	List<SendMessage> sendTop(Date insertDate);
	
	//4.查询总数
	Integer findCount(Date insertDate);
	
	//5.根据时间段查询所有
//	List<SendMessage> findAllBytime(Date insertDate);
	Integer findAllBytime(Date insertDate);
	
	//6.查询时间段内发送失败的
//	List<SendMessage> findByInsertFail(Date insertDate);
	Integer findByInsertFail(Date insertDate);
	
	List<SendMessage> findAllBytime2(Date insertDate);
	
}
