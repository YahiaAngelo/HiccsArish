package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("dr_name")
    @Expose
    private String dr_name;
    @SerializedName("dr_des")
    @Expose
    private String dr_des;
    @SerializedName("dr_img_url")
    @Expose
    private String dr_img_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrName() {
        return dr_name;
    }

    public void setDrName(String drName) {
        this.dr_name = drName;
    }

    public String getDrDes() {
        return dr_des;
    }

    public void setDrDes(String drDes) {
        this.dr_des = drDes;
    }

    public String getDrImgUrl() {
        return dr_img_url;
    }

    public void setDrImgUrl(String drImgUrl) {
        this.dr_img_url = drImgUrl;
    }

}