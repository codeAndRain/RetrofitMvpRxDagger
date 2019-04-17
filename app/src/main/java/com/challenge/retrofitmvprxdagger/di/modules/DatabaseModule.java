package com.challenge.retrofitmvprxdagger.di.modules;

import com.challenge.retrofitmvprxdagger.UserApp;
import com.challenge.retrofitmvprxdagger.data.local.UserDao;
import com.challenge.retrofitmvprxdagger.data.local.UserDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private final UserApp userApp;

    public DatabaseModule(UserApp userApp) {
        this.userApp = userApp;
    }

    @Provides
    @Singleton
    UserDatabase provideUserDatabase() {
        return Room.databaseBuilder(userApp, UserDatabase.class, "user_db").build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(UserDatabase userDatabase) {
        return userDatabase.userDao();
    }

}
