package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.api.APIRequestData;
import com.example.login.api.RetroServer;
import com.example.login.model.login.Login;
import com.example.login.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String userName, passWord;
    EditText username, password;

    SessionManager sessionManager;
    APIRequestData apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = username.getText().toString();
                passWord = password.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(MainActivity.this, "username belum di isi", Toast.LENGTH_SHORT).show();

                }
                else if (passWord.equals("")) {
                    Toast.makeText(MainActivity.this, "tanyakam padamu", Toast.LENGTH_SHORT).show();
                }
                else {
                    moveToLogin(userName, passWord);
                }
            }
        });

    }

    private void moveToLogin(String userName, String passWord) {

        apiInterface = RetroServer.getClient().create(APIRequestData.class);
        Call<Login> loginCall = apiInterface.loginResponse(userName, passWord);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(MainActivity.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);

                    //Ini untuk pindah
//                    Toast.makeText(LoginActivity.this, "Nama : " + response.body().getLoginData().getUserId(), Toast.LENGTH_SHORT).show();
                    if(response.body().getLoginData().getRole().equals("2"))
                    {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
//                      Toast.makeText(getApplicationContext(), "Status", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}