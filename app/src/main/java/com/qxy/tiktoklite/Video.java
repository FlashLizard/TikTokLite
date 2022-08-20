package com.qxy.tiktoklite;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {

    String title, time, cover, url;
    String playNum, commentNum, downloadNum, likeNum, shareNum, transmitNum;

    public Video(String title, String time, String cover,String url, String playNum, String commentNum,
                 String downloadNum, String likeNum, String shareNum, String transmitNum) {
        this.title = title;
        this.time = time;
        this.cover = cover;
        this.url = url;
        this.playNum = playNum;
        this.commentNum = commentNum;
        this.downloadNum = downloadNum;
        this.likeNum = likeNum;
        this.shareNum = shareNum;
        this.transmitNum = transmitNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.time);
        dest.writeString(this.cover);
        dest.writeString(this.url);
        dest.writeString(this.playNum);
        dest.writeString(this.commentNum);
        dest.writeString(this.downloadNum);
        dest.writeString(this.likeNum);
        dest.writeString(this.shareNum);
        dest.writeString(this.transmitNum);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.time = source.readString();
        this.cover = source.readString();
        this.url = source.readString();
        this.playNum = source.readString();
        this.commentNum = source.readString();
        this.downloadNum = source.readString();
        this.likeNum = source.readString();
        this.shareNum = source.readString();
        this.transmitNum = source.readString();
    }

    protected Video(Parcel in) {
        this.title = in.readString();
        this.time = in.readString();
        this.cover = in.readString();
        this.url = in.readString();
        this.playNum = in.readString();
        this.commentNum = in.readString();
        this.downloadNum = in.readString();
        this.likeNum = in.readString();
        this.shareNum = in.readString();
        this.transmitNum = in.readString();
    }

    public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel source) {
            return new Video(source);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };
}
