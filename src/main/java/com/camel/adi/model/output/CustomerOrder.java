package com.camel.adi.model.output;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {

    private Customer customer;
    private List<OrderItem> orders;
    @JsonProperty(value = "delivery-detail")
    private Address deliveryAddress;

    @JsonProperty(value = "total-amount")
    private TotalAmount totalAmount;

    @JsonIgnore
    private Date orderDate;
}
