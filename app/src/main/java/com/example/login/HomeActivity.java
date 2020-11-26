package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.api.APIRequestData;
import com.example.login.api.RetroServer;
import com.example.login.model.mahasiswa.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    TextView textView;
    TextView nilai;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.nama);
        nilai = findViewById(R.id.nilai);
        sessionManager = new SessionManager(HomeActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }else {
            textView.setText("Nama : " + sessionManager.getUserDetail().get(SessionManager.USERNAME));
//            if (Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.AKUMULASI)) <= 20 ){
//                nilai.setText("Nilai Anda" + sessionManager.getUserDetail().get(SessionManager.AKUMULASI + " E"));
//            }else if (Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.AKUMULASI)) <= 40 ){
//                nilai.setText("Nilai Anda" + sessionManager.getUserDetail().get(SessionManager.AKUMULASI + " D"));
//            }else if (Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.AKUMULASI)) <= 60 ){
//                nilai.setText("Nilai Anda" + sessionManager.getUserDetail().get(SessionManager.AKUMULASI + " C"));
//            }else if (Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.AKUMULASI)) <= 80 ){
//                nilai.setText("Nilai Anda" + sessionManager.getUserDetail().get(SessionManager.AKUMULASI + " B"));
//            }else if (Integer.parseInt(sessionManager.getUserDetail().get(SessionManager.AKUMULASI)) <= 100 ){
//                nilai.setText("Nilai Anda" + sessionManager.getUserDetail().get(SessionManager.AKUMULASI + " A"));
//            }else {
//                nilai.setText("Nilai Anda Tidak Di Ketahui");
//            }
            nilai.setText("Nilai Anda " + sessionManager.getUserDetail().get(SessionManager.AKUMULASI));
        }

//        retrieveData();

    }

//    private void retrieveData() {
//
//        APIRequestData ardData = RetroServer.getClient().create(APIRequestData.class);
//        Call<DataModel> tampilData = ardData.aData();
//
//        tampilData.enqueue(new Callback<DataModel>() {
//            @Override
//            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
////                Toast.makeText(getActivity(), "Status : " + status, Toast.LENGTH_SHORT).show();
//
//                nilai.setText(response.body().getData());
//            }
//
//            @Override
//            public void onFailure(Call<DataModel> call, Throwable t) {
//                Toast.makeText(HomeActivity.this, "Gagal : "+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

    private void moveToLogin() {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}