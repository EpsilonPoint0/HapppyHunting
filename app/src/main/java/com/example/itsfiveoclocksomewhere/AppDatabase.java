package com.example.itsfiveoclocksomewhere;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Bar.class, User.class, Special.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BarDao barDao();
    public abstract UserDao userDao();
    public abstract SpecialDao specialDao();
}
