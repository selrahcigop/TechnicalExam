package com.cybilltek.technicalExam.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("results")
    private List<UserModel> results;

    public List<UserModel> getResults() {
        return results;
    }

    public void setResults(List<UserModel> results) {
        this.results = results;
    }
}
