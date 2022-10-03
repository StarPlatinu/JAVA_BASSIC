/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file2;

/**
 *
 * @author thanh
 */
public class NhanVien {
    private String ma,hoten;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String ma, String hoten, double luong) {
        this.ma = ma;
        this.hoten = hoten;
        this.luong = luong;
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

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
     return ma+"\t"+hoten+"\t"+luong;
    }

    
   
    
}
