/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.main;

import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class Validation {
    public String getString(){
        Scanner sc = new Scanner(System.in);
        String result;
        while(true){
          result = sc.nextLine();
          if(result.isEmpty()){
              System.out.println("String can't be empty.");           
          }else{
              return result;
          }
        }
    }
}
