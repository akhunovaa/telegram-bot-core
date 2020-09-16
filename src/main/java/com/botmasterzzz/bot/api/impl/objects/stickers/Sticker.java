package com.botmasterzzz.bot.api.impl.objects.stickers;

import com.botmasterzzz.bot.api.BotApiObject;
import com.botmasterzzz.bot.api.impl.objects.PhotoSize;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sticker implements BotApiObject {

    private static final String FILEID_FIELD = "file_id";
    private static final String WIDTH_FIELD = "width";
    private static final String HEIGHT_FIELD = "height";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String EMOJI_FIELD = "emoji";
    private static final String SETNAME_FIELD = "set_name";
    private static final String MASKPOSITON_FIELD = "mask_position";

    @JsonProperty(FILEID_FIELD)
    private String fileId;
    @JsonProperty(WIDTH_FIELD)
    private Integer width;
    @JsonProperty(HEIGHT_FIELD)
    private Integer height;
    @JsonProperty(THUMB_FIELD)
    private PhotoSize thumb;
    @JsonProperty(FILESIZE_FIELD)
    private Integer fileSize;
    @JsonProperty(EMOJI_FIELD)
    private String emoji;
    @JsonProperty(SETNAME_FIELD)
    private String setName;
    @JsonProperty(MASKPOSITON_FIELD)
    private String maskPosition;

    public Sticker() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getSetName() {
        return setName;
    }

    public String getMaskPosition() {
        return maskPosition;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", fileSize=" + fileSize +
                ", emoji='" + emoji + '\'' +
                ", setName='" + setName + '\'' +
                ", maskPosition='" + maskPosition + '\'' +
                '}';
    }
}
