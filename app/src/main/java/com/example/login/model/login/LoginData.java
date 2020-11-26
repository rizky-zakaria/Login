package com.example.login.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("id_user")
    private String id_user;

    @SerializedName("username")
    private String username;

    @SerializedName("akumulasi")
    private Integer akumulasi;

    public Integer getAkumulasi() {
        return akumulasi;
    }

    public void setAkumulasi(Integer akumulasi) {
        this.akumulasi = akumulasi;
    }

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("laporan")
    private String laporan;

    @SerializedName("blog")
    private String blog;

    @SerializedName("video")
    private String video;

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAplikasi() {
        return aplikasi;
    }

    public void setAplikasi(String aplikasi) {
        this.aplikasi = aplikasi;
    }

    @SerializedName("aplikasi")
    private String aplikasi;


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
