package com.camel.adi.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {

	private String recordId;
	
	private String deliveryAddress;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String phoneNo;
	
}
