package com.ppa.ecomm.enums;

import lombok.Getter;

@Getter
public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment-confirmation.html","Payment Processed Successfully!"),
    ORDER_CONFIRMATION("order-confirmation.html","Order Confirmed!")
    ;

    private final String template;

    private final String subject;

    EmailTemplates(String template, String subject){
        this.template = template;
        this.subject = subject;
    };

}
