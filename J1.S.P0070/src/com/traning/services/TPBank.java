package com.traning.services;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TPBank {
	 Locale language;
	    

	    public int Menu() {
	        System.out.println("-------Login Program-------");
	        System.out.println("1. Vietnamese");
	        System.out.println("2. English");
	        System.out.println("3. Exit");
	        System.out.print("Please choice one option: ");
	        int choice = checkOptions(1, 3);
	        return choice;
	    }

	    public int checkOptions(int min, int max) {
	        Scanner scan = new Scanner(System.in);
	        int result =0;
	        while (true) {
	            try {
	                result = Integer.parseInt(scan.nextLine());
	                if (result < min || result > max) {
	                    System.out.println("Number out of range");
	                }
	                return result;
	            } catch (NumberFormatException e) {
	                System.err.println("Không hợp lệ. Xin hãy nhập lại.");
	                System.err.println("Invalid. Please re-input.");
	            }
	        }
	    }
	    // locale as the parameter which is the Locale that is to be set to this Locale.Builder instance.
	    //dinh dang ngon ngu
	    public void setLocate(Locale language) {
	        this.language = language;
	    }

	    public String Message(String key) {
	        ResourceBundle bundle = ResourceBundle.getBundle("" + this.language);
	        String message = bundle.getString(key);
	        return message;
	    }

	    public String checkInputString() {
	        Scanner scan = new Scanner(System.in);
	        String result ="";
	        while (true) {
	               result = scan.nextLine();
	            if (result.trim().isEmpty()) {
	                Message("errInputString");
	                System.out.println();
	                Message("reInput");
	            } else {
	                return result;
	            }
	        }
	    }
	    
	        public String checkAccountNumber(String accountNumber) {
	        String ACCOUNT_NUMBER = "^\\d{10}$";
	        if (accountNumber.matches(ACCOUNT_NUMBER)) {
	            return "";
	        }else {
	            return Message("errInputAccount");
	        }
	    }

	    
	    public void InputAccountNumber() {
	        int check = 0;
	        String input =  Message("enterAccountNumber");
	        while (check == 0) {
	            System.out.print(input);
	            String accountNumber = checkInputString();
	            String result = checkAccountNumber(accountNumber);
	            System.out.println(result);
	            if(!result.equals(Message("errInputAccount"))) {
	                check += 1;
	                return;
	            }
	        }
	    }

	   public String checkPassword(String password) {
	        String PASSWORD_VALID = "((?=.*\\d)(?=.*[a-zA-Z]).{8,31})";
	        if (password.matches(PASSWORD_VALID)) {
	            return "";
	        }else {
	            return Message("errPassword");
	        }
	    }
	   
	    public void InputPassword() {
	        int check = 0;
	        String input = Message("enterPassword");
	        while (check == 0) {
	            System.out.print(input);
	            String password = checkInputString();
	            String result = checkPassword(password);
	            System.out.println(result);
	            if(!result.equals(Message("errPassword"))) {
	                check += 1;
	                return;
	            }
	        }
	    }

	 public String checkCaptcha(String captchaInput, String CaptchaGenerated) {
	        if (CaptchaGenerated.contains(captchaInput)) {
	            return Message("loginSuccess");
	        }else {
	            return Message("errCaptcha");
	        }    
	    }

	    public String generateCaptcha() {
	        String root = "0123456789"
	                + "qwertyuiopasdfghjklzxcvbnm"
	                + "QWERTYUIOPASDFGHJKLZXCVBNM";
	        StringBuilder captcha = new StringBuilder();
	        Random r = new Random();
	        //r.nextInt(10);0-9 -> Use r.nextInt(length) to ram dom vi tri 
	        int length = root.length();//return the length of sequnece
	        for (int i = 0; i < 5; i++) {
	            int index = r.nextInt(length);//0->length-1
	            captcha.append(root.charAt(index));
	        }
	        return captcha.toString();
	    }

	    public void InputCaptcha(String CaptchaGenerated) {
	        int check = 0;
	        String input = Message("enterCaptcha");
	        while (check == 0) {
	            System.out.print(input);
	            String captchaInput = checkInputString();
	            String result = checkCaptcha(captchaInput, CaptchaGenerated);
	            System.out.println(result);
	            if(result.equals(Message("loginSuccess"))) {
	                check += 1;
	                return;
	            }
	        }
	    }

	    

	    public void login(Locale language) {
	        setLocate(language);
	        InputAccountNumber();
	        InputPassword();
	        String captcha = generateCaptcha();
	        System.out.println(captcha);
	        InputCaptcha(captcha);
	        System.out.println();
	        
	    }
	    public void display(){
	        TPBank Ebank = new TPBank();
	        Locale vietnamese = new Locale("vi");
	        Locale english = new Locale("en");
	        while(true) {
	            int choice = Ebank.Menu();
	            switch (choice) {
	                case 1:
	                    Ebank.login(vietnamese);
	                    break;
	                case 2:
	                    Ebank.login(english);
	                    break;
	                case 3:
	                    return;
	            }
	        }
	    }
}
