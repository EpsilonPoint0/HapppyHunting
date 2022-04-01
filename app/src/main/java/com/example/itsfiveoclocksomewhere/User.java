package com.example.itsfiveoclocksomewhere;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int userId;

    @ColumnInfo(name = "Username")
    public String username;

    @ColumnInfo(name = "Password")
    public String password;

    @ColumnInfo(name = "Uber Account ID")
    public String userUberId;

    @ColumnInfo(name = "Lyft Account ID")
    public String userLyftId;

    public User(int userId, String username, String password, String userUberId, String userLyftId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userUberId = userUberId;
        this.userLyftId = userLyftId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userUberId='" + userUberId + '\'' +
                ", userLyftId='" + userLyftId + '\'' +
                '}' + "\n";
    }
}