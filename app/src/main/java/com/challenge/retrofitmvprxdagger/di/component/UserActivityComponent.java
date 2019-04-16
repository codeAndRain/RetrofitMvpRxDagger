package com.challenge.retrofitmvprxdagger.di.component;

import com.challenge.retrofitmvprxdagger.di.modules.UserActivityModule;
import com.challenge.retrofitmvprxdagger.di.scopes.ActivityScope;
import com.challenge.retrofitmvprxdagger.ui.UserScreenActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = UserActivityModule.class)
public interface UserActivityComponent {

    void inject(UserScreenActivity userScreenActivity);
}
