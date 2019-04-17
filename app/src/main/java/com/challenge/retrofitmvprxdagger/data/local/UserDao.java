package com.challenge.retrofitmvprxdagger.data.local;

import com.challenge.retrofitmvprxdagger.model.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER_TABLE")
    Single<List<User>>  getUserList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(List<User> users);
}
