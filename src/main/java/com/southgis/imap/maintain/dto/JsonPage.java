package com.southgis.imap.maintain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class JsonPage {
	@NonNull
	private String msgString;
	@NonNull
	private Integer code;
	@NonNull
	private Object results;
	
	private Integer count;
}
