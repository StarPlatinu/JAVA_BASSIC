/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Exercise_2 {
    public static void main(String[] args) {
      File f = new File("src/com/training/file/number.txt");
        try {
        Scanner in = new Scanner(f);
        double sum = 0.0;
        DecimalFormat ft = new DecimalFormat("##.##");
        while(in.hasNext()){
            if(in.hasNextDouble()){
                double next = in.nextDouble();
                System.out.println("number = "+ft.format(next));
                sum += next;
            }else{
                in.next();
            }
        }
        in.close();
          System.out.println("Sum = "+ft.format(sum));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
      
    }
}
