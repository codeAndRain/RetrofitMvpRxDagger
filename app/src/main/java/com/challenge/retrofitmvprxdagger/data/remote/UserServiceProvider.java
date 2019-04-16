package com.challenge.retrofitmvprxdagger.data.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserServiceProvider {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private UserService userService;
    private static UserServiceProvider userServiceProvider;

    private UserServiceProvider() {
        buildRetrofit();
    }

    public static UserServiceProvider getInstance() {
        if (userServiceProvider == null) {
            userServiceProvider = new UserServiceProvider();
        }
        return userServiceProvider;
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        userService = retrofit.create(UserService.class);
    }

    public UserService getUserService() {
        return userService;
    }

}
