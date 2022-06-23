package com.camel.adi.model.input;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
	
	private String recordId;
	
	private String accountId;
	
	private Date orderDate;
	
	private String accountType;

}
