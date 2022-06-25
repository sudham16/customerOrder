package com.camel.adi.model.output;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private double itemPrice;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private double itemDiscount;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private double itemTotalAmount;


}
