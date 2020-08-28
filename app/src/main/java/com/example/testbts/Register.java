package com.example.testbts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText email ;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        final Button register = findViewById(R.id.btnregis);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register();
            }
        });
    }

    private void succes () {
        onBackPressed();
    }
    private void register (){

        registerModel registerModel = new registerModel();
        registerModel.setEmail(email.getText().toString());
        registerModel.setUsername(username.getText().toString());
        registerModel.setPassword(password.getText().toString());

        MainAPi mainAPi  = RetrofitClientInstance.getRetrofitInstance().create(MainAPi.class);

        Call<String> call = mainAPi.postRegister(registerModel);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                succes();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}