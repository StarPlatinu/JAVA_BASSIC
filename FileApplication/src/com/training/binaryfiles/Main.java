/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.binaryfiles;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanh
 */
public class Main {
    public static void main(String[] args) {
        List<SinhVien> listsv = new ArrayList<>();
        listsv.add(new SinhVien("B54", "Le Hong Quan", 7));
        listsv.add(new SinhVien("B90", "Bui Thi Lan", 7));
        listsv.add(new SinhVien("B43", "Dang Chau Anh", 7));
        IOFile.write("src/com/training/binaryfiles/sv.dat", listsv);
        List<MatHang> mathang = new ArrayList<MatHang>();
        mathang.add(new MatHang(1, "Vo hong ha", 10, 20000));
        mathang.add(new MatHang(2, "But chi 2b", 10, 10000));
        mathang.add(new MatHang(3, "Gom Tay But Chi", 10, 5000));
        IOFile.write("src/com/training/binaryfiles/mh.dat", mathang);

        
    }
}
