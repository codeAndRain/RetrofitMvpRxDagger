package com.challenge.retrofitmvprxdagger.ui;

import android.os.Bundle;

import com.challenge.retrofitmvprxdagger.R;
import com.challenge.retrofitmvprxdagger.UserApp;
import com.challenge.retrofitmvprxdagger.di.component.DaggerUserActivityComponent;
import com.challenge.retrofitmvprxdagger.di.modules.UserActivityModule;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserMvpContract;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserScreenPresenter;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class UserScreenActivity extends AppCompatActivity implements UserMvpContract.View {

    @Inject
    UserScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerUserActivityComponent.builder()
                .applicationComponent(UserApp.getInstance(this).getApplicationComponent())
                .userActivityModule(new UserActivityModule(this))
                .build().inject(this);

        presenter.getTestData();

    }

    @Override
    public void test() {
    }

}
