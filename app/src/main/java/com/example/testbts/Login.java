package com.example.testbts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText username;

    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button login = (Button) findViewById(R.id.btnlogin);

          username = (EditText) findViewById(R.id.username);
          password = findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        Button regis = (Button) findViewById(R.id.btnregis);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register();

            }
        });
    }

    private void register(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void login(){

        loginModel loginModel = new loginModel();

        loginModel.setUsername(username.getText().toString());
        loginModel.setPassword(password.getText().toString());

        MainAPi mainAPi  = RetrofitClientInstance.getRetrofitInstance().create(MainAPi.class);

        Call<String> call = mainAPi.postLogin(loginModel);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                success();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            //    Toast.makeText(this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void success(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}