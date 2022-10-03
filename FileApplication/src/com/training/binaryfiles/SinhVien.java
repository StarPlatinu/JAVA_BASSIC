/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.binaryfiles;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class SinhVien implements Serializable{
    private String ma,hoten;
    private double diem;

    public SinhVien() {
    }

    public SinhVien(String ma, String hoten, double diem) {
        this.ma = ma;
        this.hoten = hoten;
        this.diem = diem;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
      return ma+"\t"+hoten+"\t"+diem;
    }
    
}
