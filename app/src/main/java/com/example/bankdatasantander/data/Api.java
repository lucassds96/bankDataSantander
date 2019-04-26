package com.example.bankdatasantander.data;

import com.example.bankdatasantander.model.AccountInfoResponse;
import com.example.bankdatasantander.model.Login;
import com.example.bankdatasantander.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @POST("login")
    Call<LoginResponse>getLogin(@Body Login login);

    @GET("statements/1")
    Call<AccountInfoResponse> getAccountInfo(@Header("Content-Type") String header);
}
