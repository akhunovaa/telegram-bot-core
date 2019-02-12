package com.botmasterzzz.bot.api.impl.methods.send;

import com.botmasterzzz.bot.api.impl.methods.BotApiMethod;
import com.botmasterzzz.bot.api.impl.objects.Message;
import com.botmasterzzz.bot.api.impl.objects.payments.LabeledPrice;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.ApiResponse;
import com.botmasterzzz.bot.api.impl.objects.replykeyboard.InlineKeyboardMarkup;
import com.botmasterzzz.bot.exceptions.TelegramApiRequestException;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class SendInvoice  extends BotApiMethod<Message> {

    public static final String PATH = "sendinvoice";

    private static final String CHATID_FIELD = "chat_id";
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String PAYLOAD_FIELD = "payload";
    private static final String PROVIDER_TOKEN_FIELD = "provider_token";
    private static final String START_PARAMETER_FIELD = "start_parameter";
    private static final String CURRENCY_FIELD = "currency";
    private static final String PRICES_FIELD = "prices";
    private static final String PHOTO_URL_FIELD = "photo_url";
    private static final String PHOTO_SIZE_FIELD = "photo_size";
    private static final String PHOTO_WIDTH_FIELD = "photo_width";
    private static final String PHOTO_HEIGHT_FIELD = "photo_height";
    private static final String NEED_NAME_FIELD = "need_name";
    private static final String NEED_PHONE_NUMBER_FIELD = "need_phone_number";
    private static final String NEED_EMAIL_FIELD = "need_email";
    private static final String NEED_SHIPPING_ADDRESS_FIELD = "need_shipping_address";
    private static final String IS_FLEXIBLE_FIELD = "is_flexible";
    private static final String DISABLE_NOTIFICATION_FIELD = "disable_notification";
    private static final String REPLY_TO_MESSAGE_ID_FIELD = "reply_to_message_id";
    private static final String REPLY_MARKUP_FIELD = "reply_markup";
    private static final String PRIVIDER_DATA_FIELD = "provider_data";

    @JsonProperty(CHATID_FIELD)
    private Integer chatId;
    @JsonProperty(TITLE_FIELD)
    private String title;
    @JsonProperty(DESCRIPTION_FIELD)
    private String description;
    @JsonProperty(PAYLOAD_FIELD)
    private String payload;
    @JsonProperty(PROVIDER_TOKEN_FIELD)
    private String providerToken;
    @JsonProperty(START_PARAMETER_FIELD)
    private String startParameter;
    @JsonProperty(CURRENCY_FIELD)
    private String currency;
    @JsonProperty(PRICES_FIELD)
    private List<LabeledPrice> prices;
    @JsonProperty(PHOTO_URL_FIELD)
    private String photoUrl;
    @JsonProperty(PHOTO_SIZE_FIELD)
    private Integer photoSize;
    @JsonProperty(PHOTO_WIDTH_FIELD)
    private Integer photoWidth;
    @JsonProperty(PHOTO_HEIGHT_FIELD)
    private Integer photoHeight;
    @JsonProperty(NEED_NAME_FIELD)
    private Boolean needName;
    @JsonProperty(NEED_PHONE_NUMBER_FIELD)
    private Boolean needPhoneNumber;
    @JsonProperty(NEED_EMAIL_FIELD)
    private Boolean needEmail;
    @JsonProperty(NEED_SHIPPING_ADDRESS_FIELD)
    private Boolean needShippingAddress;
    @JsonProperty(IS_FLEXIBLE_FIELD)
    private Boolean isFlexible;
    @JsonProperty(DISABLE_NOTIFICATION_FIELD)
    private Boolean disableNotification;
    @JsonProperty(REPLY_TO_MESSAGE_ID_FIELD)
    private Integer replyToMessageId;
    @JsonProperty(REPLY_MARKUP_FIELD)
    private InlineKeyboardMarkup replyMarkup;
    @JsonProperty(PRIVIDER_DATA_FIELD)
    private String providerData;

    public SendInvoice() {
        super();
    }

    public SendInvoice(Integer chatId, String title, String description, String payload, String providerToken,
                       String startParameter, String currency, List<LabeledPrice> prices) {
        this.chatId = chatId;
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.providerToken = providerToken;
        this.startParameter = startParameter;
        this.currency = currency;
        this.prices = prices;
    }

    public Integer getChatId() {
        return chatId;
    }

    public SendInvoice setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SendInvoice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SendInvoice setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPayload() {
        return payload;
    }

    public SendInvoice setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public String getProviderToken() {
        return providerToken;
    }

    public SendInvoice setProviderToken(String providerToken) {
        this.providerToken = providerToken;
        return this;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public SendInvoice setStartParameter(String startParameter) {
        this.startParameter = startParameter;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public SendInvoice setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return prices;
    }

    public SendInvoice setPrices(List<LabeledPrice> prices) {
        this.prices = prices;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public SendInvoice setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Integer getPhotoSize() {
        return photoSize;
    }

    public SendInvoice setPhotoSize(Integer photoSize) {
        this.photoSize = photoSize;
        return this;
    }

    public Integer getPhotoWidth() {
        return photoWidth;
    }

    public SendInvoice setPhotoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
        return this;
    }

    public Integer getPhotoHeight() {
        return photoHeight;
    }

    public SendInvoice setPhotoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
        return this;
    }

    public Boolean getNeedName() {
        return needName;
    }

    public SendInvoice setNeedName(Boolean needName) {
        this.needName = needName;
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return needPhoneNumber;
    }

    public SendInvoice setNeedPhoneNumber(Boolean needPhoneNumber) {
        this.needPhoneNumber = needPhoneNumber;
        return this;
    }

    public Boolean getNeedEmail() {
        return needEmail;
    }

    public SendInvoice setNeedEmail(Boolean needEmail) {
        this.needEmail = needEmail;
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return needShippingAddress;
    }

    public SendInvoice setNeedShippingAddress(Boolean needShippingAddress) {
        this.needShippingAddress = needShippingAddress;
        return this;
    }

    public Boolean getFlexible() {
        return isFlexible;
    }

    public SendInvoice setFlexible(Boolean flexible) {
        isFlexible = flexible;
        return this;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public SendInvoice setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public SendInvoice setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public SendInvoice setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    public String getProviderData() {
        return providerData;
    }

    public SendInvoice setProviderData(String providerData) {
        this.providerData = providerData;
        return this;
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public Message deserializeResponse(String answer) throws TelegramApiRequestException {
        try {
            ApiResponse<Message> result = OBJECT_MAPPER.readValue(answer,
                    new TypeReference<ApiResponse<Message>>(){});
            if (result.getOk()) {
                return result.getResult();
            } else {
                throw new TelegramApiRequestException("Error sending invoice", result);
            }
        } catch (IOException e) {
            throw new TelegramApiRequestException("Unable to deserialize response", e);
        }
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (chatId == null) {
            throw new TelegramApiValidationException("ChatId parameter can't be empty", this);
        }
        if (title == null || title.isEmpty()) {
            throw new TelegramApiValidationException("Title parameter can't be empty", this);
        }
        if (description == null || description.isEmpty()) {
            throw new TelegramApiValidationException("Description parameter can't be empty", this);
        }
        if (payload == null || payload.isEmpty()) {
            throw new TelegramApiValidationException("Payload parameter can't be empty", this);
        }
        if (providerToken == null || providerToken.isEmpty()) {
            throw new TelegramApiValidationException("ProviderToken parameter can't be empty", this);
        }
        if (startParameter == null || startParameter.isEmpty()) {
            throw new TelegramApiValidationException("StartParameter parameter can't be empty", this);
        }
        if (currency == null || currency.isEmpty()) {
            throw new TelegramApiValidationException("Currency parameter can't be empty", this);
        }
        if (prices == null || prices.isEmpty()) {
            throw new TelegramApiValidationException("Prices parameter can't be empty", this);
        } else {
            for (LabeledPrice price : prices) {
                price.validate();
            }
        }
        if (replyMarkup != null) {
            replyMarkup.validate();
        }
    }

    @Override
    public String toString() {
        return "SendInvoice{" +
                "chatId=" + chatId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", payload='" + payload + '\'' +
                ", providerToken='" + providerToken + '\'' +
                ", startParameter='" + startParameter + '\'' +
                ", currency='" + currency + '\'' +
                ", prices=" + prices +
                ", photoUrl='" + photoUrl + '\'' +
                ", photoSize=" + photoSize +
                ", photoWidth=" + photoWidth +
                ", photoHeight=" + photoHeight +
                ", needName=" + needName +
                ", needPhoneNumber=" + needPhoneNumber +
                ", needEmail=" + needEmail +
                ", needShippingAddress=" + needShippingAddress +
                ", isFlexible=" + isFlexible +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", providerData='" + providerData + '\'' +
                '}';
    }
}
