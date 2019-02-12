package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PreCheckoutQuery implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String CURRENCY_FIELD = "currency";
    private static final String TOTAL_AMOUNT_FIELD = "total_amount";
    private static final String INVOICE_PAYLOAD_FIELD = "invoice_payload";
    private static final String SHIPPING_OPTION_ID_FIELD = "shipping_option_id";
    private static final String ORDER_INFO_FIELD = "order_info";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(CURRENCY_FIELD)
    private String currency;
    @JsonProperty(TOTAL_AMOUNT_FIELD)
    private Integer totalAmount;
    @JsonProperty(INVOICE_PAYLOAD_FIELD)
    private String invoicePayload;
    @JsonProperty(SHIPPING_OPTION_ID_FIELD)
    private String shippingOptionId;
    @JsonProperty(ORDER_INFO_FIELD)
    private OrderInfo orderInfo;

    public PreCheckoutQuery() {
        super();
    }

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + orderInfo +
                '}';
    }

}
