package com.challenge.retrofitmvprxdagger.di.component;

import android.content.Context;

import com.challenge.retrofitmvprxdagger.data.Repository;
import com.challenge.retrofitmvprxdagger.di.modules.ApplicationModule;
import com.challenge.retrofitmvprxdagger.di.modules.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    // Expose to sub-graphs
    Context context();
    Repository repository();
    CompositeDisposable compositeDisposable();
}
