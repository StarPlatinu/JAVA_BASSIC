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
public class MatrixProcess {
     public int checkIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Please input again.");
            }
        }
    }
     
      //Check input
    public int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Value of Matrix must be degit ");
            }
        }
        
    }
    
    public int[][] inputMatrix(int n) {
        System.out.print("Enter Row Matrix: ");
        int row = checkInputInt();
        System.out.print("Enter Colum Matrix: ");
        int col = checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + i + "]" + "[" + j + "]:");
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }
    
     public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }     
    }
     
     public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) { 
        int row = matrix1.length;
        int col = matrix1[0].length;//the number of columns on row 0
        int row2 = matrix2.length;
        int col2 = matrix2.length;
        int matrix3[][] = new int[row][col];
        if (row2 != row) {
            System.out.println("Number of rows in matrix 2 must equal to the rows in matrix 1."); 
            return null;
        } else  if (col2 != col) {
            System.out.println("The number of colum in matrix 2 must equal to colum of matrix 1.");
            return null;
        }else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
             return matrix3;
        }
       
    }
     
     public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2.length;
        int matrix3[][] = new int[row][col];
        if (row2 != row) {
            System.out.println("The number of rows 2 must equal to rows 1.");
            return null;
        }  else if (col2 != col) {
            System.out.println("The number of colums 2 must equal colums 1.");
            return null;
        } else{
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
             return matrix3;
        }        
    }
     
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int matrix3[][] = new int[row1][col2];
        //the number of columns of the first matrix must be equal
        //to the number of rows of the second matrix
        if (col1 != row2) {
            System.out.println("the number of rows matrix 2 must be equal the colums of matrix 1");
            return null;
        } else{
            //m*n with n*p => m*p
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < row2; k++) {
                        matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
                return matrix3;
        }   
    } 
    public void showMenu() {
        System.out.println("---------MENU---------");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }
    
    public void display() {
        System.out.println("Enter Matrix 1");
        int[][] matrix1 = inputMatrix(1);
        System.out.println("Enter Matrix 2");
        int[][] matrix2 = inputMatrix(2);
        MatrixProcess m = new MatrixProcess();
        while (true) {
            
            m.showMenu();
            System.out.print("Enter your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    m.displayMatrix(matrix1);
                    System.out.println("+");
                    m.displayMatrix(matrix2);
                    System.out.println("=");
                    
                    m.displayMatrix(m.additionMatrix(matrix1, matrix2));
                    break;
                case 2:
                    m.displayMatrix(matrix1);
                    System.out.println("-");
                    m.displayMatrix(matrix2);
                    System.out.println("="); 
                    m.displayMatrix(m.subtractionMatrix(matrix1, matrix2));
                    break;
                case 3:
                    m.displayMatrix(matrix1);
                    System.out.println("*");
                    m.displayMatrix(matrix2);
                    System.out.println("=");
                    m.displayMatrix(multiplicationMatrix(matrix1, matrix2));
                    break;
                case 4:
                    return;
            }
        }
    }
}
