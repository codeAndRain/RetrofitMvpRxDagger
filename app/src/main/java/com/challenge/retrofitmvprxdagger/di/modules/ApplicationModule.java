package com.challenge.retrofitmvprxdagger.di.modules;

import android.content.Context;

import com.challenge.retrofitmvprxdagger.UserApp;
import com.challenge.retrofitmvprxdagger.data.Repository;
import com.challenge.retrofitmvprxdagger.data.local.UserDao;
import com.challenge.retrofitmvprxdagger.data.remote.UserService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private final UserApp app;

    public ApplicationModule(UserApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    Repository provideRepository(UserService userService, UserDao userDao) {
        return new Repository(userService, userDao);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
