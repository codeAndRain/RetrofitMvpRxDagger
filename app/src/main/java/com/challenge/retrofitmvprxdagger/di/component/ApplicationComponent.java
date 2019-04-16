package com.challenge.retrofitmvprxdagger.di.component;

import android.content.Context;

import com.challenge.retrofitmvprxdagger.data.Repository;
import com.challenge.retrofitmvprxdagger.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // Expose to sub-graphs
    Context context();
    Repository repository();
}
