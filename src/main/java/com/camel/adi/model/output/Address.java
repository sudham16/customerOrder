package com.camel.adi.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @JsonProperty(value="delivery-address")
    private String deliveryAddress;
    @JsonProperty(value="delivery-city")
    private String city;
    @JsonProperty(value="delivery-state")
    private String state;
    private String mobileno;
    private String pincode;
}
