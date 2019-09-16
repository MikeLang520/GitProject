package com.southgis.imap.maintain.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class JsonStatistics {
	@NonNull
	private Integer code;
	
	@NonNull
	private Object list;
	
	@NonNull
	private Object list2;
	
	@NonNull
	private Integer others;
	
	@NonNull
	private Object list3;
	
	@NonNull
	private ArrayList<Integer> array1;
	
	private ArrayList<Integer> array2;
}
