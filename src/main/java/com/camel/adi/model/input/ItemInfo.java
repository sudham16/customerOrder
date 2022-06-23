package com.camel.adi.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemInfo {
	
	private String recordId;
	
	private String itemId;
	
	private String itemType;
	
	private String itemName;
	
	private int itemQuantity;
	
	private double itemPrice;

}
