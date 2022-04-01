package com.example.itsfiveoclocksomewhere;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bar {

    @PrimaryKey
    public int barId;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Monday Hours")
    public String mondayHours;

    @ColumnInfo(name = "Tuesday Hours")
    public String tuesdayHours;

    @ColumnInfo(name = "Wednesday Hours")
    public String wednesdayHours;

    @ColumnInfo(name = "Thursday Hours")
    public String thursdayHours;

    @ColumnInfo(name = "Friday Hours")
    public String fridayHours;

    @ColumnInfo(name = "Saturday Hours")
    public String saturdayHours;

    @ColumnInfo(name = "Sunday Hours")
    public String sundayHours;

    public Bar(int barId, String name, String address, String mondayHours, String tuesdayHours, String wednesdayHours, String thursdayHours, String fridayHours, String saturdayHours, String sundayHours) {
        this.barId = barId;
        this.name = name;
        this.address = address;
        this.mondayHours = mondayHours;
        this.tuesdayHours = tuesdayHours;
        this.wednesdayHours = wednesdayHours;
        this.thursdayHours = thursdayHours;
        this.fridayHours = fridayHours;
        this.saturdayHours = saturdayHours;
        this.sundayHours = sundayHours;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "barId=" + barId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mondayHours='" + mondayHours + '\'' +
                ", tuesdayHours='" + tuesdayHours + '\'' +
                ", wednesdayHours='" + wednesdayHours + '\'' +
                ", thursdayHours='" + thursdayHours + '\'' +
                ", fridayHours='" + fridayHours + '\'' +
                ", saturdayHours='" + saturdayHours + '\'' +
                ", sundayHours='" + sundayHours + '\'' +
                '}' + "\n";
    }
}