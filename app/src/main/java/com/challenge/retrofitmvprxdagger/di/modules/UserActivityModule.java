package com.challenge.retrofitmvprxdagger.di.modules;

import com.challenge.retrofitmvprxdagger.data.Repository;
import com.challenge.retrofitmvprxdagger.di.scopes.ActivityScope;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserMvpContract;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class UserActivityModule {

    private final UserMvpContract.View view;

    public UserActivityModule(UserMvpContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public UserScreenPresenter provideUserScreenPresenter(Repository repository) {
        return new UserScreenPresenter(view, repository);
    }
}
