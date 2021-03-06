package com.example.bankdatasantander.model;

import com.example.bankdatasantander.model.AccountInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountInfoResponse {
    @SerializedName("statementList")
    @Expose
    private List<AccountInfo> accountInfos;


    public List<AccountInfo> getAccountInfos() {
        return accountInfos;
    }

    public void setAccountInfos(List<AccountInfo> accountInfos) {
        this.accountInfos = accountInfos;
    }
}
