package com.cybilltek.technicalExam.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cybilltek.technicalExam.model.UserEntity;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<UserEntity> getAllUsers();

    @Insert
    void insertUsers(List<UserEntity> users);

    // Add other CRUD operations as needed
}
