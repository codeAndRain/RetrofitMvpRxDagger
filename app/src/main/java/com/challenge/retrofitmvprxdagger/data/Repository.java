package com.challenge.retrofitmvprxdagger.data;

import com.challenge.retrofitmvprxdagger.data.local.UserDao;
import com.challenge.retrofitmvprxdagger.data.remote.UserService;
import com.challenge.retrofitmvprxdagger.model.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    private final UserService userService;
    private final UserDao userDao;

    @Inject
    public Repository(UserService userService, UserDao userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }

    private Single<List<User>> getRemoteUserList() {
        return userService.getUserList();
    }

    public Single<List<User>> getUserList() {
        return userDao.getUserList()
                .flatMap(users -> {
                    if (users.isEmpty()) {
                        insertUsers(users);
                        return getRemoteUserList();
                    } else {
                        return getLocalUserList();
                    }
                });
    }

    private Single<List<User>> getLocalUserList() {
        return userDao.getUserList();
    }

    private void insertUsers(List<User> users) {
        Completable.fromSingle(completable -> userDao.insertUsers(users))
                .subscribeOn(Schedulers.io()).subscribe();
    }
}
