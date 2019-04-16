package com.challenge.retrofitmvprxdagger.di.modules;

import android.content.Context;

import com.challenge.retrofitmvprxdagger.UserApp;
import com.challenge.retrofitmvprxdagger.data.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

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
    Repository provideRepository() {
        return new Repository();
    }
}
