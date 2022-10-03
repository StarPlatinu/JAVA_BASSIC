/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class QLNV {

    private NhanVien[] nv;
    private int n;

    public QLNV() {
        nv = new NhanVien[100];
        n = 0;
    }

    public NhanVien[] getNv() {
        return nv;
    }

    public void setNv(NhanVien[] nv) {
        this.nv = nv;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private int tontai(String ma) {
        for (int i = 0; i < n; i++) {
            if (nv[n].getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        String ma, ten;
        double luong;
        String re = "^B\\d{2}";
        while (true) {
            try {
                System.out.print("Ma: ");
                ma = sc.nextLine().toUpperCase();
                if (ma.matches(re) && (tontai(ma) == -1)) {
                    break;
                } else {
                    throw new ValidException("Ma ko dung dinh dang or trung ma");
                }
            } catch (ValidException e) {
                System.err.println(e);
            }
        }
        re = "[a-zA-Z ]+";
        while (true) {
            try {
                System.out.print("Ho va ten: ");
                ten = sc.nextLine();
                if(ten.matches(re)){
                    break;
                }else{
                    throw new ValidException("ten chi gom chu va dau cach");
                }
            } catch (ValidException e) {
                System.out.println(e);
            }
        }
        
           re = "[\\d.]";
        while (true) {
            try {
                System.out.print("Nhap Luong: ");
                luong = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhap so");
            }
        }
        nv[n++] = new NhanVien(ma, ten, luong);
    }
    /** Ham doc du lieu tu file
     * 
     * @param fname 
     */
public void docra(String fname){
    NhanVien[] nv = new NhanVien[100];
    int count = 0;
    String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fname)));
            while((line=br.readLine())!=null){
                String[] s = line.split(";");
                nv[count++] = new NhanVien(s[0], s[1], Double.parseDouble(s[2]));
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLNV.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            System.out.println(ex);
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        setN(count);
        setNv(nv);
}

public void hienthi(){
    System.out.println("Danh sach nhan vien");
    for (int i = 0; i < n; i++) {
        System.out.println(nv[i]);  
    }
    System.out.println("---------------------------");
}
public void luufile(String fname){
    String st = "";
    for (int i = 0; i < n; i++) {
        st += nv[i].getMa()+";"+nv[i].getHoten()+";"+nv[i].getLuong()+"\n";
    }
    st += nv[n-1].getMa()+";"+nv[n-1].getHoten()+";"+nv[n-1].getLuong();
        try {
            PrintWriter pt = new PrintWriter(fname);
            pt.print(st);
            pt.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLNV.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
