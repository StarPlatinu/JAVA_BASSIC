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
public class MatHang implements Serializable{
    private int ma;
    private String tenHang;
    private int soLuong;
    private double donGia;

    public MatHang() {
    }

    public MatHang(int ma, String tenHang, int soLuong, double donGia) {
        this.ma = ma;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
       return ma+"\t"+tenHang+"\t"+soLuong+"\t"+donGia+"\t"+(soLuong*donGia);
    }
    
    
}
