package com.botmasterzzz.bot.api.impl.objects;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Arrays;

public class OutgoingMessage implements Serializable {

    private String typeMessage;
    private byte[] data;

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutgoingMessage that = (OutgoingMessage) o;
        return Objects.equal(typeMessage, that.typeMessage) &&
                Objects.equal(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(typeMessage, data);
    }

    @Override
    public String toString() {
        return "OutgoingMessage{" +
                "typeMessage='" + typeMessage + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
