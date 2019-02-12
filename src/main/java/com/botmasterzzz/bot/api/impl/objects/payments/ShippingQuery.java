package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingQuery implements BotApiObject {

    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String INVOICE_PAYLOAD_FIELD = "invoice_payload";
    private static final String SHIPPING_ADDRESS_FIELD = "shipping_address";

    @JsonProperty(ID_FIELD)
    private String id;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(INVOICE_PAYLOAD_FIELD)
    private String invoicePayload;
    @JsonProperty(SHIPPING_ADDRESS_FIELD)
    private ShippingAddress shippingAddress;

    public ShippingQuery() {
        super();
    }

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public String toString() {
        return "ShippingQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }


}
