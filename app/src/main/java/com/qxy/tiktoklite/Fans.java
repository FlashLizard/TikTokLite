package com.qxy.tiktoklite;

public class Fans {
    String avatarPath, name, address;
    Male male = Male.NULL;

    public Fans(String avatarPath,String name, String address, Male male) {
        this.avatarPath = avatarPath;
        this.name = name;
        this.address = address;
        this.male = male;
    }
}
