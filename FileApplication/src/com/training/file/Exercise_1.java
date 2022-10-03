/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

/**
 *
 * @author thanh
 */
import java.io.*;// for File, FileNotFoundException
import java.text.DecimalFormat;
import java.util.Scanner;
public class Exercise_1 {
    //Display the first 5 numbers in the given file
    //and displays their sum at the end.
    public static void main(String[] args)  {//throws FileNotFoundException
        //-Cach 1
//        Scanner in = new Scanner(new File("src/com/training/file/number.txt"));
//        double sum = 0.0;
//        for (int i = 0; i <= 5; i++) {
//            double next = in.nextDouble();
//            System.out.println("number = "+next);
//            sum+=next;
//        }
//        System.out.println("Sum = "+sum);

        //-Cach 2
        File f = new File("src/com/training/file/number.txt");
        
        try {
            Scanner sc = new Scanner(f);
            double x;
            double t = 0;
            DecimalFormat ft = new DecimalFormat("##.##");
            for (int i = 0; i < 5; i++) {
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
