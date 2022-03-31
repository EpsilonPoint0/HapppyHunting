package com.example.itsfiveoclocksomewhere;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Special {

    @PrimaryKey
    public int specialId;

    @ColumnInfo(name = "Location")
    public int location;

    @ColumnInfo(name = "Start Time")
    public double startTime;

    @ColumnInfo(name = "End Time")
    public double endTime;

    @ColumnInfo(name = "Start Day")
    public double startDay;

    @ColumnInfo(name = "End Day")
    public double endDay;

    @ColumnInfo(name = "Special Information")
    public String specialInfo;

    public Special(int location, double startTime, double endTime, double startDay, double endDay, String specialInfo) {
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDay = startDay;
        this.endDay = endDay;
        this.specialInfo = specialInfo;
    }

    @Override
    public String toString() {
        return "Special{" +
                "location=" + location +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", specialInfo='" + specialInfo + '\'' +
                '}' + "\n";
    }
}