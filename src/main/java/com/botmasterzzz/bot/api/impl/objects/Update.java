package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.payments.PreCheckoutQuery;
import com.botmasterzzz.bot.api.impl.objects.payments.ShippingQuery;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Update implements BotApiObject {

    private static final String UPDATEID_FIELD = "update_id";
    private static final String MESSAGE_FIELD = "message";
    private static final String CALLBACKQUERY_FIELD = "callback_query";
    private static final String EDITEDMESSAGE_FIELD = "edited_message";
    private static final String CHANNELPOST_FIELD = "channel_post";
    private static final String EDITEDCHANNELPOST_FIELD = "edited_channel_post";
    private static final String SHIPPING_QUERY_FIELD = "shipping_query";
    private static final String PRE_CHECKOUT_QUERY_FIELD = "pre_checkout_query";

    @JsonProperty(UPDATEID_FIELD)
    private Integer updateId;
    @JsonProperty(MESSAGE_FIELD)
    private Message message;
    @JsonProperty(CALLBACKQUERY_FIELD)
    private CallbackQuery callbackQuery;
    @JsonProperty(EDITEDMESSAGE_FIELD)
    private Message editedMessage;
    @JsonProperty(CHANNELPOST_FIELD)
    private Message channelPost;
    @JsonProperty(EDITEDCHANNELPOST_FIELD)
    private Message editedChannelPost;
    @JsonProperty(SHIPPING_QUERY_FIELD)
    private ShippingQuery shippingQuery;
    @JsonProperty(PRE_CHECKOUT_QUERY_FIELD)
    private PreCheckoutQuery preCheckoutQuery;

    public Update() {
        super();
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public Message getEditedMessage() {
        return editedMessage;
    }

    public Message getChannelPost() {
        return channelPost;
    }

    public Message getEditedChannelPost() {
        return editedChannelPost;
    }

    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    public boolean hasMessage() {
        return message != null;
    }

    public boolean hasCallbackQuery() {
        return callbackQuery != null;
    }

    public boolean hasEditedMessage() {
        return editedMessage != null;
    }

    public boolean hasChannelPost() {
        return channelPost != null;
    }

    public boolean hasEditedChannelPost() {
        return editedChannelPost != null;
    }

    public boolean hasShippingQuery() {
        return shippingQuery != null;
    }

    public boolean hasPreCheckoutQuery() {
        return preCheckoutQuery != null;
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateId=" + updateId +
                ", message=" + message +
                ", callbackQuery=" + callbackQuery +
                ", editedMessage=" + editedMessage +
                ", channelPost=" + channelPost +
                ", editedChannelPost=" + editedChannelPost +
                ", shippingQuery=" + shippingQuery +
                ", preCheckoutQuery=" + preCheckoutQuery +
                '}';
    }
}
