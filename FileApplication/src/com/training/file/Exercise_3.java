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
public class Exercise_3 {
    public static void main(String[] args) {
        File f = new File("src/com/training/file/hn.txt");
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
        }
    }
}
