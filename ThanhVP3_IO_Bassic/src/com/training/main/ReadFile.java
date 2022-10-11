package com.training.main;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("data.txt");
		System.out.println("Numer of remaining bytes:" + fin.available());
		fin.skip(5);
		System.out.println("FileContents :");
		int ch;
		while ((ch = fin.read()) != -1) {
			System.out.print((char) ch);
		}
		fin.close();
		System.out.println("---------WriteFile------");
		DataInputStream dis = new DataInputStream(System.in);
		FileOutputStream fout = new FileOutputStream("file.txt");
		BufferedOutputStream bout = new BufferedOutputStream(fout,1024);
		System.out.println("Enter text (@) at the end: ");
		char c;
		while((c=(char)dis.read())!='@') {
			bout.write(ch);
		}
		bout.close();
	}
}
