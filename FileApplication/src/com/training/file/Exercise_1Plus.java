/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Exercise_1Plus {
    public static void main(String[] args) {
             File f = new File("src/com/training/file/number.txt");
        
        try {
            Scanner sc = new Scanner(f);
            double x;
            double t = 0;
            DecimalFormat ft = new DecimalFormat("##.##");
            while (sc.hasNextDouble()) {
                x = sc.nextFloat();
                System.out.println("Number:"+ft.format(x));
                t+=x;
            }
            sc.close();
            System.out.println("Tong:"+ft.format(t));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
