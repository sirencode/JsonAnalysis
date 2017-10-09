package com.diablo.jsonanalysis;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Diablo on 2017/10/9.
 */
@JsonObject
public class MyJsonObj {
    @JsonField
    public String name;
    @JsonField
    public String city;
    @JsonField
    public int age;
    @JsonField
    public long date;
    @JsonField
    public String Period;
    @JsonField
    public String ListId;
    @JsonField
    public String Market;
    @JsonField
    public String LongP;
    @JsonField
    public String ShortP;
    @JsonField
    public String Value;
    @JsonField
    public String TradeTime;
    @JsonField
    public int LastRegion;
    @JsonField
    public int CurrentRegion;
    @JsonField
    public int Signals;
    @JsonField
    public Son son;

    @JsonObject
    public static class Son {
        @JsonField
        public int age;
        @JsonField
        public String wife;
        @JsonField
        public String company;
        @JsonField
        public String college;
        @JsonField
        public String profession;
    }

    @Override
    public String toString() {
        return "MyJsonObj{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", Period='" + Period + '\'' +
                ", ListId='" + ListId + '\'' +
                ", Market='" + Market + '\'' +
                ", LongP='" + LongP + '\'' +
                ", ShortP='" + ShortP + '\'' +
                ", Value='" + Value + '\'' +
                ", TradeTime='" + TradeTime + '\'' +
                ", LastRegion=" + LastRegion +
                ", CurrentRegion=" + CurrentRegion +
                ", Signals=" + Signals +
                '}';
    }
}
