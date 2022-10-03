/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Exercise_2Plus {
    public static void main(String[] args) {
      File f = new File("src/com/training/file/number.txt");
        try {
        Scanner in = new Scanner(f);
        double sum = 0.0;
        while(in.hasNext()){
            if(in.hasNext()){
                double next = in.nextDouble();
                System.out.println("number = "+next);
                sum += next;
            }else{
                in.next();
            }
        }
        in.close();
          System.out.println("Sum = "+sum);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
