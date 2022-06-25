package com.camel.adi;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.camel.adi.mapper.OrderMapper;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import com.camel.adi.model.input.AccountInfo;
import com.camel.adi.model.input.DeliveryInfo;
import com.camel.adi.model.input.ItemInfo;
import com.camel.adi.model.input.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {
	public static OrderInfo getOrderInfo(String val) {
		// TODO Auto-generated method stub
		
		 StreamFactory factory = StreamFactory.newInstance();
	        factory.loadResource("OrderInfo.xml");
	        
	        //read it from the classpath : src/main/resources
	        //InputStream in = new ByteArrayInputStream(getInput().getBytes());
	        InputStream in = new ByteArrayInputStream(val.getBytes());
	        BeanReader reader = factory.createReader("orderInfo", new InputStreamReader(in));
	        Object record = null;
	       OrderInfo info = new OrderInfo();
	       List<ItemInfo> itemInfos = new ArrayList<ItemInfo>();
	        
	        // read records from "input.csv"
	        while ((record = reader.read()) != null)
	        {
	            if ("accountInfo".equals(reader.getRecordName()))
	            {

	               AccountInfo accountInfo = (AccountInfo) record;
	               info.setAccountInfo(accountInfo);
	            }
	            else if ("itemInfo".equals(reader.getRecordName()))
	            {
	            	ItemInfo itemInfo = (ItemInfo) record;
	            	itemInfos.add(itemInfo);
	            }
	            else if ("deliveryInfo".equals(reader.getRecordName()))
	            {
	            	DeliveryInfo deliveryInfo = (DeliveryInfo) record;
	            	info.setDeliveryInfo(deliveryInfo);
	            }
	        }
	        
	        info.setItemInfoList(itemInfos);
	        System.out.println(info);
	        return info;

	}
	
	private static String getInput() {
		return "A|TM0003|14-12-2020|REGULAR\n"
				+ "I|IT0031|Grocery|ABC Surf|1|1|30.00\n"
				+ "I|IT0025|Book|Zero to One, Peter Thiel|1|500.00\n"
				+ "D|B-001, Hinjewadi-1|Pune|Maharashtra|411057|9999911111";
	}

}
