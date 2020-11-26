package com.example.login.model.mahasiswa;

import com.example.login.model.login.LoginData;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("data")
    private Integer data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
