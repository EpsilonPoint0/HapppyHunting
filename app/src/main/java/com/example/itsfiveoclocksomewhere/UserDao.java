package com.example.itsfiveoclocksomewhere;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("SELECT * FROM User WHERE userId = (:username)")
    User selectUserByUserName(String username);

    @Query("SELECT * FROM User WHERE userId = (:username) AND Password = (:password)")
    User selectUserByUserNameAndPassword(String username, String password);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllUsers(User... users);

    @Delete
    void deleteUser(User user);

}