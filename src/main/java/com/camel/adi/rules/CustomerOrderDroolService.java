package com.camel.adi.rules;

import com.camel.adi.model.output.CustomerOrder;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("com.camel.adi.rules")
public class CustomerOrderDroolService {
    @Autowired
    private KieContainer kieContainer;

    public CustomerOrder calculateAmountAndDiscount(CustomerOrder customerOrder) {
        KieSession kieSession = kieContainer.newKieSession();
        //kieSession.setGlobal("customerOrder", customerOrder);
        kieSession.insert(customerOrder);
        System.out.println("Firing Rules");
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(customerOrder);

        return customerOrder;
    }
}
