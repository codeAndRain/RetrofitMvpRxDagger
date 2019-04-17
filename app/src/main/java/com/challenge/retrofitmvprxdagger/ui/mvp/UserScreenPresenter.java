package com.challenge.retrofitmvprxdagger.ui.mvp;

import com.challenge.retrofitmvprxdagger.data.Repository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserScreenPresenter {

    private final UserMvpContract.View view;
    private final Repository repository;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public UserScreenPresenter(UserMvpContract.View view, Repository repository, CompositeDisposable compositeDisposable) {
        this.view = view;
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
    }

    public void getUserList() {
        addDisposable(repository.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showProgressBar(true))
               .doFinally(() -> view.showProgressBar(false))
                .subscribe(view::setUsers, throwable -> view.showError(throwable.getMessage())));
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }
}
