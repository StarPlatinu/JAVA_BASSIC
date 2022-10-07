package com.training.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Validation {
	private static Scanner in = new Scanner(System.in);

	/**
	 * get number with max min data
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getInteger(int min, int max) {
		while (true) {
			try {
				int n = Integer.parseInt(in.nextLine());
				if (n < min || n > max) {
					throw new NumberFormatException();
				}
				return n;
			} catch (NumberFormatException e) {
				System.err.println("Re-input!!!");
			}

		}
	}

	/**
	 * get non-empty String
	 * 
	 * @return
	 */
	public static String getString() {
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				String str = in.nextLine().trim();
				if (str.length() == 0) {
					throw new NumberFormatException();
				}
				return str;
			} catch (NumberFormatException e) {
				System.err.println("Not empty!!!");
			}
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	public static void zipFile() throws IOException {
		System.out.println("Enter source Folder: ");
		String pathSrc = getString();
		System.out.println("Enrer Distination Folder");
		String pathCompress = getString();
		System.out.println("Enter name: ");
		String fileZipName = in.nextLine();
		boolean check = compressTo(pathSrc, fileZipName, pathCompress);
		if (check == true) {
			System.out.println("Successfully");
		} else {
			System.out.println("Fail");
		}

	}

	/**
	 * compressTo
	 * 
	 * @param pathSrc
	 * @param fileZipName
	 * @param pathCompress
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean compressTo(String pathSrc, String fileZipName, String pathCompress)
			throws FileNotFoundException, IOException {
//        String sourceFile = "D:/Test2/FileName1.txt";
		String sourceFile = pathSrc;
		String nameFos = pathCompress + "/" + fileZipName + ".zip";
//        FileOutputStream fos = new FileOutputStream("D:/Test/FileZip.zip");
		FileOutputStream fos = new FileOutputStream(nameFos);
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		File fileToZip = new File(sourceFile);
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		zipOut.putNextEntry(zipEntry);
		final byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		zipOut.close();
		fis.close();
		fos.close();
		return true;
	}

	/**
	 * 
	 * @throws IOException
	 */
	public static void unzipFile() throws IOException {
		System.out.print("Enter Source file: ");
		String pathZipFile = getString();
		System.out.print("Enter Destination Folder: ");
		String pathExtract = getString();
		boolean check = extractTo(pathZipFile, pathExtract);
		if (check == true) {
			System.out.println("Successfully");
		} else {
			System.out.println("Fail");
		}
	}

	/**
	 * 
	 * @param pathZipFile
	 * @param pathExtract
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean extractTo(String pathZipFile, String pathExtract) throws FileNotFoundException, IOException {
//       String fileZip = "D:/Test/FileZip.zip";
		String fileZip = pathZipFile;
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
		ZipEntry zipEntry = zis.getNextEntry();
		while (zipEntry != null) {
			String fileName = zipEntry.getName();
//           File newFile = new File("D:/Test/" + fileName);
			File newFile = new File(pathExtract + fileName);
			FileOutputStream fos = new FileOutputStream(newFile);
			int len;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			zipEntry = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
		return true;
	}

	/**
	 * 
	 * @throws IOException
	 */
	public static void getMain() throws IOException {
		while (true) {
			System.out.println("1. Compression");
			System.out.println("2. Extraction");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choose = getInteger(1, 3);
			switch (choose) {
			case 1:
				zipFile();
				break;
			case 2:
				unzipFile();
				break;
			case 3:
				return;
			}
		}
	}

}
