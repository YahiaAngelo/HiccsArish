package com.hiccs.arish.models;

import android.media.Image;

import org.w3c.dom.Text;

public class StaffModel {
    private int dr_img;
    private String dr_name,dr_des;

    public int getDr_img() {
        return dr_img;
    }

    public void setDr_img(int dr_img) {
        this.dr_img = dr_img;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getDr_des() {
        return dr_des;
    }

    public void setDr_des(String dr_des) {
        this.dr_des = dr_des;
    }

    public StaffModel(int dr_img, String dr_name, String dr_des) {
        this.dr_img = dr_img;
        this.dr_name = dr_name;
        this.dr_des = dr_des;
    }

    public StaffModel(int dr_img, Text dr_name, Text dr_des) {
        this.dr_img = dr_img;

    }


}