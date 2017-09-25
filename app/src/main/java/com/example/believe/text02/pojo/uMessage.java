package com.example.believe.text02.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by BELIEVE on 2017/9/25.
 */

public class uMessage implements Parcelable{
    private int m_id;
    private String title;
    private String type;
    private String content;
    private String time;

    protected uMessage(Parcel in) {
        m_id = in.readInt();
        title = in.readString();
        type = in.readString();
        content = in.readString();
        time = in.readString();
        u_name = in.readString();
    }

    public static final Creator<uMessage> CREATOR = new Creator<uMessage>() {
        @Override
        public uMessage createFromParcel(Parcel in) {
            return new uMessage(in);
        }

        @Override
        public uMessage[] newArray(int size) {
            return new uMessage[size];
        }
    };

    @Override
    public String toString() {
        return "uMessage{" +
                "m_id=" + m_id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", u_name='" + u_name + '\'' +
                '}';
    }

    private String u_name;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(m_id);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeString(content);
        dest.writeString(time);
        dest.writeString(u_name);
    }
}
