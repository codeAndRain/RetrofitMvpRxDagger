package com.challenge.retrofitmvprxdagger.data.remote;

import com.challenge.retrofitmvprxdagger.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserService {

    @GET("todos")
    Single<List<User>> getUserList();
}
