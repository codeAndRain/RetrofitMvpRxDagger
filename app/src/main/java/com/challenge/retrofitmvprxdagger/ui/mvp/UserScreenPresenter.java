package com.challenge.retrofitmvprxdagger.ui.mvp;

import com.challenge.retrofitmvprxdagger.data.Repository;

import javax.inject.Inject;

public class UserScreenPresenter {

    private final UserMvpContract.View view;
    private final Repository repository;

    @Inject
    public UserScreenPresenter(UserMvpContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }


    public void getTestData() {
        repository.getTestData();
    }
}
