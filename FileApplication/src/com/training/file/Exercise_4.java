/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
public class Exercise_4 {
    public static void main(String[] args) {
        String fname = "src/com/training/file/nv.dat";
        try {         
            Scanner sc = new Scanner(new File(fname));
            String line;
            DecimalFormat f = new DecimalFormat("##.##");
            while(sc.hasNextLine()){
              line = sc.nextLine();
              String[] s = line.split(";");
              String st = s[1]+"(ID#"+s[0]+")";
              int count =0;
              double so = 0;
                for (int i = 2; i < s.length; i++) {
                    so += Double.parseDouble(s[i]);
                    count ++;
                }
                double avg = so/count;
                st+=f.format(so)+" hours ("+f.format(avg)+" hours a day)";
                System.out.println(st);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercise_4.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException ex){
            System.out.println(ex);
        }
    }
}
