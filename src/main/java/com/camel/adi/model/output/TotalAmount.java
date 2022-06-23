package com.camel.adi.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalAmount {
    private String itemAmount;
    private String shippingCharge;
    private String orderTotal;
}
