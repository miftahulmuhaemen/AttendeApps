package com.unlam.developerstudentclub.attendemapsnusa.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {

    @SerializedName("login_status")
    @Expose @Setter
    @Getter
    private Boolean status;

    @SerializedName("msg")
    @Expose @Setter @Getter
    private String msg;

    @SerializedName("id")
    @Expose @Setter @Getter
    private String id;

    @SerializedName("no")
    @Expose @Setter @Getter
    private String no;

    @SerializedName("nama")
    @Expose @Setter @Getter
    private String nama;


}
