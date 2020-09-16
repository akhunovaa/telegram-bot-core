package com.botmasterzzz.bot.api.impl.objects;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.games.Game;
import com.botmasterzzz.bot.api.impl.objects.passport.PassportData;
import com.botmasterzzz.bot.api.impl.objects.payments.Invoice;
import com.botmasterzzz.bot.api.impl.objects.payments.SuccessfulPayment;
import com.botmasterzzz.bot.api.impl.objects.stickers.Sticker;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.animation.Animation;

import java.util.List;

public class Message implements BotApiObject {

    private static final String MESSAGEID_FIELD = "message_id";
    private static final String FROM_FIELD = "from";
    private static final String DATE_FIELD = "date";
    private static final String CHAT_FIELD = "chat";
    private static final String FORWARDFROM_FIELD = "forward_from";
    private static final String FORWARDFROMCHAT_FIELD = "forward_from_chat";
    private static final String FORWARDDATE_FIELD = "forward_date";
    private static final String TEXT_FIELD = "text";
    private static final String ENTITIES_FIELD = "entities";
    private static final String CAPTIONENTITIES_FIELD = "caption_entities";
    private static final String AUDIO_FIELD = "audio";
    private static final String DOCUMENT_FIELD = "document";
    private static final String PHOTO_FIELD = "photo";
    private static final String STICKER_FIELD = "sticker";
    private static final String VIDEO_FIELD = "video";
    private static final String CONTACT_FIELD = "contact";
    private static final String LOCATION_FIELD = "location";
    private static final String VENUE_FIELD = "venue";
    private static final String ANIMATION_FIELD = "animation";
    private static final String PINNED_MESSAGE_FIELD = "pinned_message";
    private static final String NEWCHATMEMBERS_FIELD = "new_chat_members";
    private static final String LEFTCHATMEMBER_FIELD = "left_chat_member";
    private static final String NEWCHATTITLE_FIELD = "new_chat_title";
    private static final String NEWCHATPHOTO_FIELD = "new_chat_photo";
    private static final String DELETECHATPHOTO_FIELD = "delete_chat_photo";
    private static final String GROUPCHATCREATED_FIELD = "group_chat_created";
    private static final String REPLYTOMESSAGE_FIELD = "reply_to_message";
    private static final String VOICE_FIELD = "voice";
    private static final String CAPTION_FIELD = "caption";
    private static final String SUPERGROUPCREATED_FIELD = "supergroup_chat_created";
    private static final String CHANNELCHATCREATED_FIELD = "channel_chat_created";
    private static final String MIGRATETOCHAT_FIELD = "migrate_to_chat_id";
    private static final String MIGRATEFROMCHAT_FIELD = "migrate_from_chat_id";
    private static final String EDITDATE_FIELD = "edit_date";
    private static final String GAME_FIELD = "game";
    private static final String FORWARDFROMMESSAGEID_FIELD = "forward_from_message_id";
    private static final String INVOICE_FIELD = "invoice";
    private static final String SUCCESSFUL_PAYMENT_FIELD = "successful_payment";
    private static final String VIDEO_NOTE_FIELD = "video_note";
    private static final String AUTHORSIGNATURE_FIELD = "author_signature";
    private static final String FORWARDSIGNATURE_FIELD = "forward_signature";
    private static final String MEDIAGROUPID_FIELD = "media_group_id";
    private static final String CONNECTEDWEBSITE_FIELD = "connected_website";
    private static final String PASSPORTDATA_FIELD = "passport_data";

    @JsonProperty(MESSAGEID_FIELD)
    private Integer messageId;
    @JsonProperty(FROM_FIELD)
    private User from;
    @JsonProperty(DATE_FIELD)
    private Integer date;
    @JsonProperty(CHAT_FIELD)
    private Chat chat;
    @JsonProperty(FORWARDFROM_FIELD)
    private User forwardFrom;
    @JsonProperty(FORWARDFROMCHAT_FIELD)
    private Chat forwardFromChat;
    @JsonProperty(FORWARDDATE_FIELD)
    private Integer forwardDate;
    @JsonProperty(TEXT_FIELD)
    private String text;
    @JsonProperty(ENTITIES_FIELD)
    private List<MessageEntity> entities;
    @JsonProperty(CAPTIONENTITIES_FIELD)
    private List<MessageEntity> captionEntities;
    @JsonProperty(AUDIO_FIELD)
    private Audio audio;
    @JsonProperty(DOCUMENT_FIELD)
    private Document document;
    @JsonProperty(PHOTO_FIELD)
    private List<PhotoSize> photo;
    @JsonProperty(STICKER_FIELD)
    private Sticker sticker;
    @JsonProperty(VIDEO_FIELD)
    private Video video;
    @JsonProperty(CONTACT_FIELD)
    private Contact contact;
    @JsonProperty(LOCATION_FIELD)
    private Location location;
    @JsonProperty(VENUE_FIELD)
    private Venue venue;
    @JsonProperty(ANIMATION_FIELD)
    private Animation animation;
    @JsonProperty(PINNED_MESSAGE_FIELD)
    private Message pinnedMessage;
    @JsonProperty(NEWCHATMEMBERS_FIELD)
    private List<User> newChatMembers;
    @JsonProperty(LEFTCHATMEMBER_FIELD)
    private User leftChatMember;
    @JsonProperty(NEWCHATTITLE_FIELD)
    private String newChatTitle;
    @JsonProperty(NEWCHATPHOTO_FIELD)
    private List<PhotoSize> newChatPhoto;
    @JsonProperty(DELETECHATPHOTO_FIELD)
    private Boolean deleteChatPhoto;
    @JsonProperty(GROUPCHATCREATED_FIELD)
    private Boolean groupchatCreated;
    @JsonProperty(REPLYTOMESSAGE_FIELD)
    private Message replyToMessage;
    @JsonProperty(VOICE_FIELD)
    private Voice voice;
    @JsonProperty(CAPTION_FIELD)
    private String caption;
    @JsonProperty(SUPERGROUPCREATED_FIELD)
    private Boolean superGroupCreated;
    @JsonProperty(CHANNELCHATCREATED_FIELD)
    private Boolean channelChatCreated;
    @JsonProperty(MIGRATETOCHAT_FIELD)
    private Long migrateToChatId;
    @JsonProperty(MIGRATEFROMCHAT_FIELD)
    private Long migrateFromChatId;
    @JsonProperty(EDITDATE_FIELD)
    private Integer editDate;
    @JsonProperty(GAME_FIELD)
    private Game game;
    @JsonProperty(FORWARDFROMMESSAGEID_FIELD)
    private Integer forwardFromMessageId;
    @JsonProperty(INVOICE_FIELD)
    private Invoice invoice;
    @JsonProperty(SUCCESSFUL_PAYMENT_FIELD)
    private SuccessfulPayment successfulPayment;
    @JsonProperty(VIDEO_NOTE_FIELD)
    private VideoNote videoNote;
    @JsonProperty(AUTHORSIGNATURE_FIELD)
    private String authorSignature;
    @JsonProperty(FORWARDSIGNATURE_FIELD)
    private String forwardSignature;
    @JsonProperty(MEDIAGROUPID_FIELD)
    private String mediaGroupId;
    @JsonProperty(CONNECTEDWEBSITE_FIELD)
    private String connectedWebsite;
    @JsonProperty(PASSPORTDATA_FIELD)
    private PassportData passportData;

    public Message() {
        super();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public Integer getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public Integer getForwardDate() {
        return forwardDate;
    }

    public String getText() {
        return text;
    }

    public List<MessageEntity> getEntities() {
        if (entities != null) {
            entities.forEach(x -> x.computeText(text));
        }
        return entities;
    }

    public List<MessageEntity> getCaptionEntities() {
        if (captionEntities != null) {
            captionEntities.forEach(x -> x.computeText(caption));
        }
        return captionEntities;
    }

    public Audio getAudio() {
        return audio;
    }

    public Document getDocument() {
        return document;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public boolean hasSticker() {
        return sticker != null;
    }

    public Video getVideo() {
        return video;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public Venue getVenue() {
        return venue;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    public User getLeftChatMember() {
        return leftChatMember;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public Boolean getGroupchatCreated() {
        return groupchatCreated;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public Voice getVoice() {
        return voice;
    }

    public String getCaption() {
        return caption;
    }

    public Boolean getSuperGroupCreated() {
        return superGroupCreated;
    }

    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    public Long getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public Integer getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public boolean isGroupMessage() {
        return chat.isGroupChat();
    }

    public boolean isUserMessage() {
        return chat.isUserChat();
    }

    public boolean isChannelMessage() {
        return chat.isChannelChat();
    }

    public boolean isSuperGroupMessage() {
        return chat.isSuperGroupChat();
    }

    public Long getChatId() {
        return chat.getId();
    }

    public boolean hasText() {
        return text != null && !text.isEmpty();
    }

    public boolean isCommand() {
        if (hasText() && entities != null) {
            for (MessageEntity entity : entities) {
                if (entity != null && entity.getOffset() == 0 &&
                        EntityType.BOTCOMMAND.equals(entity.getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasDocument() {
        return this.document != null;
    }

    public boolean hasVideo() {
        return this.video != null;
    }

    public boolean isReply() {
        return this.replyToMessage != null;
    }

    public boolean hasLocation() {
        return location != null;
    }

    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    public Integer getEditDate() {
        return editDate;
    }

    public Game getGame() {
        return game;
    }

    private boolean hasGame() {
        return game != null;
    }

    public boolean hasEntities() {
        return entities != null && !entities.isEmpty();
    }

    public boolean hasPhoto() {
        return photo != null && !photo.isEmpty();
    }

    public boolean hasInvoice() {
        return invoice != null;
    }

    public boolean hasSuccessfulPayment() {
        return successfulPayment != null;
    }

    public boolean hasContact() {
        return contact != null;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    public VideoNote getVideoNote() {
        return videoNote;
    }

    public boolean hasVideoNote() {
        return videoNote != null;
    }

    public String getAuthorSignature() {
        return authorSignature;
    }

    public String getForwardSignature() {
        return forwardSignature;
    }

    public String getMediaGroupId() {
        return mediaGroupId;
    }

    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public boolean hasPassportData() {
        return passportData != null;
    }

    public boolean hasAnimation() {
        return animation != null;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardFromChat=" + forwardFromChat +
                ", forwardDate=" + forwardDate +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                ", captionEntities=" + captionEntities +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", pinnedMessage=" + pinnedMessage +
                ", newChatMembers=" + newChatMembers +
                ", leftChatMember=" + leftChatMember +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + newChatPhoto +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupchatCreated=" + groupchatCreated +
                ", replyToMessage=" + replyToMessage +
                ", voice=" + voice +
                ", caption='" + caption + '\'' +
                ", superGroupCreated=" + superGroupCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatId=" + migrateToChatId +
                ", migrateFromChatId=" + migrateFromChatId +
                ", editDate=" + editDate +
                ", game=" + game +
                ", forwardFromMessageId=" + forwardFromMessageId +
                ", invoice=" + invoice +
                ", successfulPayment=" + successfulPayment +
                ", videoNote=" + videoNote +
                ", authorSignature='" + authorSignature + '\'' +
                ", forwardSignature='" + forwardSignature + '\'' +
                ", mediaGroupId='" + mediaGroupId + '\'' +
                ", connectedWebsite='" + connectedWebsite + '\'' +
                ", passportData=" + passportData +
                '}';
    }
}
