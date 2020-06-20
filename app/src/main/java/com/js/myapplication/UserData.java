package com.js.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable {

    private String name;
    private String mbti;
    private int grade;
    private String region;

    public UserData() {
        name = "";
        mbti = "";
        grade = 0;
        region = "";
    }

     public UserData(String name, String mbti, int grade, String region) {
        this.name = name;
        this.mbti = mbti;
        this.grade = grade;
        this.region = region;
     }

    protected UserData(Parcel in) {
        name = in.readString();
        mbti = in.readString();
        grade = in.readInt();
        region = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(mbti);
        dest.writeInt(grade);
        dest.writeString(region);
    }

    private void readToParcel(Parcel in) {
        this.name = in.readString();
        this.mbti = in.readString();
        this.grade = in.readInt();
        this.region = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };
}


