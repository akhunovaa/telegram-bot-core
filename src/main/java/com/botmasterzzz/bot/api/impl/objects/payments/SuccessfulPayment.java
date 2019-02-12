package com.botmasterzzz.bot.api.impl.objects.payments;

import com.botmasterzzz.bot.api.BotApiObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessfulPayment implements BotApiObject {
    private static final String CURRENCY_FIELD = "currency";
    private static final String TOTAL_AMOUNT_FIELD = "total_amount";
    private static final String INVOICE_PAYLOAD_FIELD = "invoice_payload";
    private static final String SHIPPING_OPTION_ID_FIELD = "shipping_option_id";
    private static final String ORDER_INFO_FIELD = "order_info";
    private static final String TELEGRAM_PAYMENT_CHARGE_ID_FIELD = "telegram_payment_charge_id";
    private static final String PROVIDER_PAYMENT_CHARGE_ID_FIELD = "provider_payment_charge_id";

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
    @JsonProperty(TELEGRAM_PAYMENT_CHARGE_ID_FIELD)
    private String telegramPaymentChargeId;
    @JsonProperty(PROVIDER_PAYMENT_CHARGE_ID_FIELD)
    private String providerPaymentChargeId;

    public SuccessfulPayment() {
        super();
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

    public String getTelegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    public String getProviderPaymentChargeId() {
        return providerPaymentChargeId;
    }

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + orderInfo +
                ", telegramPaymentChargeId='" + telegramPaymentChargeId + '\'' +
                ", providerPaymentChargeId='" + providerPaymentChargeId + '\'' +
                '}';
    }

}
