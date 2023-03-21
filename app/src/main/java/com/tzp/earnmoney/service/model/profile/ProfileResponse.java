package com.tzp.earnmoney.service.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("balance_usd")
    @Expose
    private Integer balanceUsd;
    @SerializedName("referral_id")
    @Expose
    private String referralId;
    @SerializedName("image")
    @Expose
    private String image;

    public ProfileResponse(Integer id, String name, String email, Integer balance, Integer balanceUsd, String referralId, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.balanceUsd = balanceUsd;
        this.referralId = referralId;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalanceUsd() {
        return balanceUsd;
    }

    public void setBalanceUsd(Integer balanceUsd) {
        this.balanceUsd = balanceUsd;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
