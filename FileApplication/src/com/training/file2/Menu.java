/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file2;

import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Menu {
    public static void main(String[] args) {
        QLNV q = new QLNV();
        String fname = "src/com/training/file2/nv.dat";
        while(true){
            System.out.println("1. Nhap nhan vien");
            System.out.println("2. Hien thi nhan vien");
            System.out.println("3. Luu vao file");
            System.out.println("4. Doc tu file");
            System.out.println("0. Thoat");
            System.out.println("Moi chon (0-4):");
            int chon;
            Scanner sc = new Scanner(System.in);
            chon = sc.nextInt();
            switch (chon) {
                case 0:
                    System.out.println("bye!!!");
                    System.exit(0);//safe exit
                 break;
                case 1:
                    q.nhap();
                 break;
                case 2:
                    q.hienthi();
                 break;
                case 3:
                    q.luufile(fname);
                 break;
                case 4:
                    q.docra(fname);
                 break;
                default:
                       System.out.println("Plai chon 0 - 4");
                    break;
            }
            
        }
    }
}
