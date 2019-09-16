package com.southgis.imap.maintain.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity(name="sendmessage")
public class SendMessage {
	
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="native")
	private Integer id;
	
	private String smid;
	
	//所属公司
	private String company;
	
	private String org;
	//是否发送成功
	private String dest;
	
	private String senddata;
	
	//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date insertDate;
	
	//是否发送成功?success or fail
	private Integer status;
	
	private String msgGroup;
	
	private String reportStatus;
	
	private String errorCode;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date receiveDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sendDate;
	
	
	

}
