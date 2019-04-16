package com.challenge.retrofitmvprxdagger;

import android.app.Application;
import android.content.Context;

import com.challenge.retrofitmvprxdagger.di.component.ApplicationComponent;
import com.challenge.retrofitmvprxdagger.di.component.DaggerApplicationComponent;
import com.challenge.retrofitmvprxdagger.di.modules.ApplicationModule;

public class UserApp extends Application {

    private static  ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static UserApp getInstance(Context context) {
        return (UserApp) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
