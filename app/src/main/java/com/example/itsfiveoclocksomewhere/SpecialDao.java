package com.example.itsfiveoclocksomewhere;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SpecialDao {

    @Query("SELECT * FROM Special")
    List<Special> getAllSpecials();

    @Query("SELECT * FROM Special WHERE location = (:id)")
    Special selectSpecialbyLocation(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllSpecials(Special... specials);

    @Delete
    void deleteSpecial(Special special);

}
