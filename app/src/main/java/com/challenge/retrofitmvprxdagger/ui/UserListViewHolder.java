package com.challenge.retrofitmvprxdagger.ui;

import android.view.View;
import android.widget.TextView;

import com.challenge.retrofitmvprxdagger.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

class UserListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.id_text)
    TextView idTextView;
    @BindView(R.id.title_text)
    TextView titleTextView;

    public UserListViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public  void bind() {

    }
}
