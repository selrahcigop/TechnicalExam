package com.cybilltek.technicalExam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cybilltek.technicalExam.adapter.UserAdapter;
import com.cybilltek.technicalExam.interfaces.OnItemClickListener;
import com.cybilltek.technicalExam.model.UserModel;
import com.cybilltek.technicalExam.model.UserResponse;
import com.cybilltek.technicalExam.util.DateUtil;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnItemClickListener {

    public static String api = "https://randomuser.me/";
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterfaces.getUser().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    if (userResponse != null && userResponse.getResults() != null) {
                        List<UserModel> userModels = userResponse.getResults();
                        int size = userModels.size();
                        Log.e("api", "Number of users fetched: " + size);

                        // Iterate through the list of users
                        for (int i = 0; i < Math.min(size, 5); i++) { // Limit to the first 5 users
                            UserModel user = userModels.get(i);
                            String firstName = user.getName().getFirstName();
                            String lastName = user.getName().getLastName();
                            Log.e("api", "User " + (i + 1) + ": " + firstName + " " + lastName);
                        }
                        // Update adapter with all users
                        if (!userModels.isEmpty()) {
                            Log.e("api", "First user: " + userModels.get(3).toString());
                            adapter = new UserAdapter(userModels, MainActivity.this);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("api", "No users found");
                        }
                    } else {
                        Log.e("api", "User response or results is null");
                    }
                } else {
                    Log.e("api", "onResponse error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("api", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(UserModel user) {
//        Toast.makeText(this, user.getPhone() + " " + user.getName().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, UserDetailsActivity.class);
        intent.putExtra("firstName", user.getName().getFirstName());
        intent.putExtra("lastName", user.getName().getLastName());
        intent.putExtra("dob", DateUtil.truncateToDate(String.valueOf(user.getDob().getDate())));
        intent.putExtra("age", String.valueOf(user.getDob().getAge()));
        intent.putExtra("email", user.getEmail());
        intent.putExtra("phone", user.getPhone());
        intent.putExtra("address", user.getLocation().getCity());
        intent.putExtra("country", user.getLocation().getCountry());
//        intent.putExtra("contact", String.valueOf(user.getContact().getContactPhoneNumber()));
//        intent.putExtra("person", String.valueOf(user.getContact().getContactPerson()));
        startActivity(intent);

    }
}