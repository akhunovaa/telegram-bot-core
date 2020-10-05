package com.botmasterzzz.bot.api.impl.objects.stickers;

import com.botmasterzzz.bot.api.InputBotApiObject;
import com.botmasterzzz.bot.api.Validable;
import com.botmasterzzz.bot.exceptions.TelegramApiValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MaskPosition implements InputBotApiObject, Validable {
    private static final String POINT_FIELD = "point";
    private static final String XSHIFT_FIELD = "x_shift";
    private static final String YSHIFT_FIELD = "y_shift";
    private static final String SCALE_FIELD = "scale";

    @JsonProperty(POINT_FIELD)
    private String point;
    @JsonProperty(XSHIFT_FIELD)
    private Float xShift;
    @JsonProperty(YSHIFT_FIELD)
    private Float yShift;
    @JsonProperty(SCALE_FIELD)
    private Float scale;

    public MaskPosition() {
        super();
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Float getxShift() {
        return xShift;
    }

    public void setxShift(Float xShift) {
        this.xShift = xShift;
    }

    public Float getyShift() {
        return yShift;
    }

    public void setyShift(Float yShift) {
        this.yShift = yShift;
    }

    public Float getScale() {
        return scale;
    }

    public void setScale(Float scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "MaskPosition{" +
                "point='" + point + '\'' +
                ", xShift=" + xShift +
                ", yShift=" + yShift +
                ", scale=" + scale +
                '}';
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (point == null || point.isEmpty()) {
            throw new TelegramApiValidationException("point can't be empty", this);
        }
        if (xShift == null) {
            throw new TelegramApiValidationException("xShift can't be empty", this);
        }
        if (yShift == null) {
            throw new TelegramApiValidationException("yShift can't be empty", this);
        }
        if (scale == null) {
            throw new TelegramApiValidationException("scale can't be empty", this);
        }
    }
}
