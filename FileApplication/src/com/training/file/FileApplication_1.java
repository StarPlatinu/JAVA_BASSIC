/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.file;

import java.io.File;

/**
 *
 * @author thanh
 */
public class FileApplication_1 {
    public static void main(String[] args) {
        File f = new File("src/com/training/file/hn.txt");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());
        System.out.println(f.length());
        System.out.println(f.lastModified());
    }
}
