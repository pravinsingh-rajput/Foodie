package com.pravinsingh.foodie1;
import com.pravinsingh.foodie1.Modules.MsgModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetroFitApi {

    @GET
    Call<MsgModel> getMessage(@Url String url);
}
