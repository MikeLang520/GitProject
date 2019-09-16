package com.southgis.imap.maintain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class JsonTime {
	@NonNull
	private Integer code;
	@NonNull
	private Object results;
	
	private Integer count;

}
