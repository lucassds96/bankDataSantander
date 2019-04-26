package com.example.bankdatasantander.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bankdatasantander.R;
import com.example.bankdatasantander.adapter.AccountListAdapter;
import com.example.bankdatasantander.model.AccountInfo;
import com.example.bankdatasantander.model.AccountInfoResponse;
import com.example.bankdatasantander.model.BankViewModel;
import com.example.bankdatasantander.model.LoginResponse;

import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private BankViewModel bankViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Bundle bundle = getIntent().getExtras();
        LoginResponse loginResponse = (LoginResponse) bundle.getSerializable("user");

        if (loginResponse != null)
        setUserData(loginResponse);
        bankViewModel = ViewModelProviders.of(this).get(BankViewModel.class);
        accountInfo();
        logout();
    }

    private void setUserData(LoginResponse loginResponse) {
        TextView clientName = findViewById(R.id.client_name);
        TextView account = findViewById(R.id.account);
        TextView balance = findViewById(R.id.balance);

        clientName.setText(loginResponse.getClientData().getName());
        account.setText(loginResponse.getClientData().getBankAccount() + "/" + loginResponse.getClientData().getAgency());
        balance.setText("R$" + loginResponse.getClientData().getBalance().toString());
    }

    private void accountInfo() {
        bankViewModel.getAccountInfoResponse().observe(this, new Observer<AccountInfoResponse>() {
            @Override
            public void onChanged(@Nullable AccountInfoResponse response) {
                if (!response.getAccountInfos().isEmpty())
                    setupRecyclerView(response.getAccountInfos());
            }
        });
    }

    private void logout() {
        ImageView logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupRecyclerView(List<AccountInfo> accountInfos) {
        mRecyclerView = findViewById(R.id.list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        AccountListAdapter accountListAdapter = new AccountListAdapter(accountInfos);
        mRecyclerView.setAdapter(accountListAdapter);
    }
}
