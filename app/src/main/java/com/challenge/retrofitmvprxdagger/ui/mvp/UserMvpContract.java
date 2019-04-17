package com.challenge.retrofitmvprxdagger.ui.mvp;

import com.challenge.retrofitmvprxdagger.model.User;

import java.util.List;

public interface UserMvpContract {

    interface View {

        void setUsers(List<User> users);

        void showError(String message);

        void showProgressBar(boolean isVisible);
    }

}
