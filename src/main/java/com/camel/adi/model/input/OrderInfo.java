package com.camel.adi.model.input;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
	
	private AccountInfo accountInfo;
	
	private List<ItemInfo> itemInfoList;
	
	private DeliveryInfo deliveryInfo;

}
