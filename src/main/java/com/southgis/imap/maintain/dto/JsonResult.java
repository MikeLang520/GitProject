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
public class JsonResult {
	@NonNull
	private String msg;
	@NonNull
	private Integer code;
	private Object results;
}
