package com.cybilltek.technicalExam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cybilltek.technicalExam.model.UserModel;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        // Get UserModel object from Intent extras
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String dob = intent.getStringExtra("dob");
        String age = intent.getStringExtra("age");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String contact = intent.getStringExtra("contact");
        String person = intent.getStringExtra("person");
        String country = intent.getStringExtra("country");

        // Set user details in TextViews
        TextView firstNameTextView = findViewById(R.id.textViewFirstName);
        TextView lastNameTextView = findViewById(R.id.textViewLastName);
        TextView birthdayTextView = findViewById(R.id.textViewBirthday);
        TextView ageTextView = findViewById(R.id.textViewAge);
        TextView emailTextView = findViewById(R.id.textViewEmail);
        TextView mobileNumberTextView = findViewById(R.id.textViewMobileNumber);
        TextView addressTextView = findViewById(R.id.textViewAddress);
        TextView contactPersonTextView = findViewById(R.id.textViewContactPerson);
        TextView contactPersonPhoneNumberTextView = findViewById(R.id.textViewContactPersonPhoneNumber);

            firstNameTextView.setText(firstName);
            lastNameTextView.setText(lastName);
            birthdayTextView.setText(dob);
            ageTextView.setText(String.valueOf(age));
            emailTextView.setText(email);
            mobileNumberTextView.setText(phone);
            addressTextView.setText(address + ", " + country);
            contactPersonTextView.setText(person);
            contactPersonPhoneNumberTextView.setText(contact);

    }
}

