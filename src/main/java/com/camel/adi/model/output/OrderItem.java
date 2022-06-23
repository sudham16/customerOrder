package com.camel.adi.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private String itemId;
	private String itemType;
	private String itemName;
	private String itemQuantity;
	private String itemPrice;
	private String itemDiscount;
	private String itemTotalAmount;


}
