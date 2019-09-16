package com.southgis.imap.maintain.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Entity(name="smsinfo")
public class SmsInfo {
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="native")
	private Integer CID;
	
	/*公司账户*/
	private String Caccount;
	
	
	/*公司名称*/
	private String Ccompany;
	
	/*公司移动电话*/
	private String Cmobile;
	
	/*公司电话*/
	private String Cmobile1111;
	
	/*公司地址*/
	private String Caddress;
	
	/*公司所属省份*/
	private String Cprovince;
	
	/*公司邮政编号*/
	private String Czip;
	
	/*公司电话号码*/
	private String Ctel;
	
	
	/*公司传真*/
	private String Cfax;
	
	/*公司员工姓名*/
	private String Cname;
	
	/*登录密码*/
	private String Cpassword;
	
	/*公司问题*/
	private String Cquestion;
	
	/*公司反应*/
	private String Canswer;
	
	/*公司笔记*/
	private String Cnote;
	
	//时间
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date createtime;

}
