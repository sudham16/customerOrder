package com.camel.adi.mapper;

import com.camel.adi.model.input.AccountInfo;
import com.camel.adi.model.input.DeliveryInfo;
import com.camel.adi.model.input.ItemInfo;
import com.camel.adi.model.input.OrderInfo;
import com.camel.adi.model.output.Customer;
import com.camel.adi.model.output.CustomerOrder;
import com.camel.adi.model.output.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(target = "customer.accountId",source = "orderInfo.accountInfo.accountId")
    @Mapping(target = "customer.customerAddress",source = "orderInfo.deliveryInfo")
    @Mapping(target = "orders",source = "orderInfo.itemInfoList")
    @Mapping(target = "deliveryAddress",source = "orderInfo.deliveryInfo")
    @Mapping(target = "orderDate", source = "accountInfo.orderDate")
    @Mapping(target = "weekDay", source = "orderInfo", qualifiedByName = "isWeekDay")
    CustomerOrder toCustomerOrder(OrderInfo orderInfo);

  @Named("isWeekDay")
   default boolean isWeekDay(OrderInfo orderInfo){
        Calendar cal = Calendar.getInstance();
      System.out.println("Date is "+orderInfo.getAccountInfo().getOrderDate());
        cal.setTime(orderInfo.getAccountInfo().getOrderDate());
        int day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("Day is" +day);
        if (day == 7 || day == 1){
            return false;
        }
        return true;
    }

}
