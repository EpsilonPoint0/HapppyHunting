package com.example.itsfiveoclocksomewhere;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BarDao {

    @Query("SELECT * FROM Bar")
    List<Bar> getAllBars();

    @Query("SELECT * FROM Bar WHERE barId = (:id)")
    Bar selectBarById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllBars(Bar... bars);

    @Delete
    void deleteBar(Bar bar);

}