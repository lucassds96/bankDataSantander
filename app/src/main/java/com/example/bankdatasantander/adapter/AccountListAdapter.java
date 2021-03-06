package com.example.bankdatasantander.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bankdatasantander.model.AccountInfo;
import com.example.bankdatasantander.R;

import java.util.List;

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountListViewHolder> {
    private List<AccountInfo> mData;

    public static class AccountListViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView date;
        public TextView value;
        public AccountListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.payment);
            desc = itemView.findViewById(R.id.payment_type);
            date = itemView.findViewById(R.id.date);
            value = itemView.findViewById(R.id.value);
        }
    }

    public AccountListAdapter(List<AccountInfo> accountInfos) {
        this.mData = accountInfos;
    }

    @NonNull
    @Override
    public AccountListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View accountView = layoutInflater.inflate(R.layout.item_recycler_view, viewGroup, false);

        return new AccountListViewHolder(accountView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountListViewHolder accountListViewHolder, int i) {
        AccountInfo accountInfo = mData.get(i);

        TextView title = accountListViewHolder.title;
        title.setText(accountInfo.getTitle());
        TextView desc = accountListViewHolder.desc;
        desc.setText(accountInfo.getDesc());
        TextView date = accountListViewHolder.date;
        date.setText(accountInfo.getDate());
        TextView value = accountListViewHolder.value;
        value.setText("R$ " + accountInfo.getValue().toString());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
