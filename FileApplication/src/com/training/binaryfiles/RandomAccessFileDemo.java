/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.training.binaryfiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanh
 */
/*
A demo. for write data to a file then read data from the file
The try..catch statement must be used when accessing file-checked exception
*/
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        String fname = "RandomAccessFileDemo.txt";
        String s1 = "Blue Eye"; boolean b = true; int n = 1234;
        double x = 37.456;String s2 = "Ichigo Minamoto";
        byte[] ar = new byte[100];//for reading ASCII characters
        try {       
            RandomAccessFile f = new RandomAccessFile(fname, "rw");
            // Write data, positions: 0,1,2,3,4
            f.writeUTF(s1);
            f.writeBoolean(b);
            f.writeInt(n);
            f.writeDouble(x);
            f.writeBytes(s2);
            //Read data
            f.seek(0);  //seek to BOF
            System.out.println(f.readUTF());
            System.out.println(f.readBoolean());
            System.out.println(f.readInt());
            System.out.println(f.readDouble());
            f.read(ar);
            System.out.println(new String(ar));
            System.out.println("File length: "+f.length());
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFileDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
