package com.challenge.retrofitmvprxdagger.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge.retrofitmvprxdagger.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
