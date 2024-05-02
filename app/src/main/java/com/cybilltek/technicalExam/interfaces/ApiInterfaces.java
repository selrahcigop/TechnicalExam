package com.cybilltek.technicalExam.interfaces;

import com.cybilltek.technicalExam.model.UserModel;
import com.cybilltek.technicalExam.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaces {

    @GET("api/?results=50")
//    @GET("api/?results=50")
    Call<UserResponse> getUser();

}
