package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.ChosenInlineQuery;
import com.botmasterzzz.bot.api.impl.objects.inlinequery.InlineQuery;
import com.botmasterzzz.bot.api.impl.objects.payments.PreCheckoutQuery;
import com.botmasterzzz.bot.api.impl.objects.payments.ShippingQuery;
import com.botmasterzzz.bot.api.impl.objects.polls.Poll;
import com.botmasterzzz.bot.api.impl.objects.polls.PollAnswer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Update implements BotApiObject {

    private static final String UPDATEID_FIELD = "update_id";
    private static final String MESSAGE_FIELD = "message";
    private static final String INLINEQUERY_FIELD = "inline_query";
    private static final String CHOSENINLINEQUERY_FIELD = "chosen_inline_result";
    private static final String CALLBACKQUERY_FIELD = "callback_query";
    private static final String EDITEDMESSAGE_FIELD = "edited_message";
    private static final String CHANNELPOST_FIELD = "channel_post";
    private static final String EDITEDCHANNELPOST_FIELD = "edited_channel_post";
    private static final String SHIPPING_QUERY_FIELD = "shipping_query";
    private static final String PRE_CHECKOUT_QUERY_FIELD = "pre_checkout_query";
    private static final String POLL_FIELD = "poll";
    private static final String POLLANSWER_FIELD = "poll_answer";


    @JsonProperty(UPDATEID_FIELD)
    private Integer updateId;
    @JsonProperty(MESSAGE_FIELD)
    private Message message;
    @JsonProperty(INLINEQUERY_FIELD)
    private InlineQuery inlineQuery;
    @JsonProperty(CHOSENINLINEQUERY_FIELD)
    private ChosenInlineQuery chosenInlineQuery;
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
    @JsonProperty(POLL_FIELD)
    private Poll poll;

    @JsonProperty(POLLANSWER_FIELD)
    private PollAnswer pollAnswer;


    public Update() {
        super();
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public ChosenInlineQuery getChosenInlineQuery() {
        return chosenInlineQuery;
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

    public Poll getPoll() {
        return poll;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    public boolean hasMessage() {
        return message != null;
    }

    public boolean hasInlineQuery() {
        return inlineQuery != null;
    }

    public boolean hasChosenInlineQuery() {
        return chosenInlineQuery != null;
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

    public boolean hasPoll() {
        return poll != null;
    }

    public boolean hasPollAnswer() {
        return pollAnswer != null;
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateId=" + updateId +
                ", message=" + message +
                ", inlineQuery=" + inlineQuery +
                ", chosenInlineQuery=" + chosenInlineQuery +
                ", callbackQuery=" + callbackQuery +
                ", editedMessage=" + editedMessage +
                ", channelPost=" + channelPost +
                ", editedChannelPost=" + editedChannelPost +
                ", shippingQuery=" + shippingQuery +
                ", preCheckoutQuery=" + preCheckoutQuery +
                ", poll=" + poll +
                ", pollAnswer=" + pollAnswer +
                '}';
    }
}
