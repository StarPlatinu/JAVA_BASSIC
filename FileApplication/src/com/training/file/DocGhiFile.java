/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author thanh
 */
public class DocGhiFile {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
       if(!file.exists()){
           file.createNewFile();
       }
        FileInputStream fileInputStream = new FileInputStream(file);
        
    }
}
