package com.camel.adi.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@JsonProperty(value="account_Id")
	private String accountId;
	@JsonProperty(value="customer-address")
	private Address customerAddress;

}
