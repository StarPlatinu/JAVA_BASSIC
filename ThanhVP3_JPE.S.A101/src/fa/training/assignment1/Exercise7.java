package fa.training.assignment1;

import java.util.Scanner;

public class Exercise7 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a;  
    int b; 
  
    System.out.print( "Input first integer: " );   
    a = sc.nextInt(); 

    System.out.print( "Input second integer: " );   
    b = sc.nextInt();             
    
    if ( a == b )           
        System.out.printf( "%d == %d\n", a, b );  
    if ( a != b )          
        System.out.printf( "%d != %d\n", a, b );  
    if ( a < b )          
        System.out.printf( "%d < %d\n", a, b );  
    if ( a > b )          
        System.out.printf( "%d > %d\n", a, b );  
    if ( a <= b )          
        System.out.printf( "%d <= %d\n", a, b );  
    if ( a >= b )          
        System.out.printf( "%d >= %d\n", a, b );  
    sc.close();
}
}
