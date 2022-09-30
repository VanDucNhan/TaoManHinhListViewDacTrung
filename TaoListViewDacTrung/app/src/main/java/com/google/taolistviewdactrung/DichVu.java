package com.google.taolistviewdactrung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DichVu {
    private String tendichvu;
    private String motadichvu;
    private int hinh;

    public DichVu(String tendichvu, String motadichvu, int hinh) {
        this.tendichvu = tendichvu;
        this.motadichvu = motadichvu;
        this.hinh = hinh;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public String getMotadichvu() {
        return motadichvu;
    }

    public void setMotadichvu(String motadichvu) {
        this.motadichvu = motadichvu;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public static class Detail extends AppCompatActivity {


    }
}
