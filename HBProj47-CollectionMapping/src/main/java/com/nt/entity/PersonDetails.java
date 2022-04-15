package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
	private  Integer pid;
	private  String pname;
	private  String paddrs;
	private  List<String> nickNames;
	private List<String> friends;
	private  Set<Long> contactNumbers;
	private  Map<String,Long> idDetails;
	

}
