/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.binaryfiles;

import java.util.List;

/**
 *
 * @author thanh
 */
public class Main2 {
    public static void main(String[] args) {
        List<SinhVien> list1 = IOFile.read("src/com/training/binaryfiles/sv.dat");
        List<MatHang> list2 = IOFile.read("src/com/training/binaryfiles/mh.dat");
        
        System.out.println("Danh sach sinh vien");
        for (SinhVien s : list1) {
            System.out.println(s);
        }
        
         for (MatHang r : list2) {
             System.out.println(r);
        }
    }
}
