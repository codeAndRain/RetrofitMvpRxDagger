package com.challenge.retrofitmvprxdagger.data.local;

import com.challenge.retrofitmvprxdagger.model.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
