package com.southgis.imap.maintain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.southgis.imap.maintain.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  SouthProject启动成功   ლ(´ڡ`ლ)ﾞ  \n");
	}
	
}



	