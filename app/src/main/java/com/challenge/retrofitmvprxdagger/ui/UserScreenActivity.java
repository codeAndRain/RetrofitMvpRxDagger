package com.challenge.retrofitmvprxdagger.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.challenge.retrofitmvprxdagger.R;
import com.challenge.retrofitmvprxdagger.UserApp;
import com.challenge.retrofitmvprxdagger.di.component.DaggerUserActivityComponent;
import com.challenge.retrofitmvprxdagger.di.modules.UserActivityModule;
import com.challenge.retrofitmvprxdagger.model.User;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserMvpContract;
import com.challenge.retrofitmvprxdagger.ui.mvp.UserScreenPresenter;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserScreenActivity extends AppCompatActivity implements UserMvpContract.View {

    @Inject
    UserScreenPresenter presenter;

    @BindView(R.id.users_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerUserActivityComponent.builder()
                .applicationComponent(UserApp.getInstance(this).getApplicationComponent())
                .userActivityModule(new UserActivityModule(this))
                .build().inject(this);

        initViews();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getUserList();
    }

    private void initViews() {
        userListAdapter = new UserListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userListAdapter);
    }

    @Override
    public void setUsers(List<User> users) {
        userListAdapter.setItems(users);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }
}
