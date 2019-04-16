package com.challenge.retrofitmvprxdagger.data;

import android.util.Log;

import com.challenge.retrofitmvprxdagger.data.remote.UserService;
import com.challenge.retrofitmvprxdagger.data.remote.UserServiceProvider;

public class Repository {

    private UserService userService;
    private UserServiceProvider userServiceProvider;

    public Repository() {
        userServiceProvider = UserServiceProvider.getInstance();
        userService = userServiceProvider.getUserService();
    }


    public void getTestData(){
        Log.d("TAG_1", "Repository started!");
    }
}
