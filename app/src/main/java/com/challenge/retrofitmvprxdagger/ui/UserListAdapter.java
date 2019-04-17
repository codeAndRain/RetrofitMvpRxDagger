package com.challenge.retrofitmvprxdagger.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge.retrofitmvprxdagger.R;
import com.challenge.retrofitmvprxdagger.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    List<User> userList = new ArrayList<>();

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setItems(List<User> users) {
        if (!userList.isEmpty()) {
            userList.clear();
        }
        userList.addAll(users);
        notifyDataSetChanged();
    }
}
