package com.camel.adi.model.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalAmount {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double itemAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double shippingCharge;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double orderTotal;
}
