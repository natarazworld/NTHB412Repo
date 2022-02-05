package com.nt.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Stock {
	private Integer stockId;
	@NonNull
	private String stockName;
	@NonNull
	private  double price;
	@NonNull
	private  String exchange;
	private  Timestamp  lastUpdated;   // for Object Timestamping

}
