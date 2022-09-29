package com.training.main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author thanh
 */
public class Main {

    /**
    Design a program that allows users to input the string value. 
    Count and display the number of letters and characters
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validation v = new Validation();
        Counter c = new Counter();
        System.out.println("Enter your content: ");
        String content = v.getString();
        c.analyze(content);
        c.display();
    }
    
}
