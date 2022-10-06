package com.traning.uitils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {
	private Scanner sc = new Scanner(System.in);
	private static final String EMAIL_VALID = "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$";
	private static final String PHONE_VALID = "(0[3|5|7|8|9])+([0-9]{8})";
	private static final String STRING_VALID = "[A-Za-z\\s]+";

	/**
	 * get non-empty string
	 * 
	 * @param mess
	 * @return
	 */
	public String inputString(String mess) {

		String string;
		while (true) {
			System.out.print(mess);
			string = sc.nextLine();
			// force user input exactly non-empty string
			if (!string.trim().isEmpty()) {
				break;
			} else {
				System.out.println("Invalid input, please enter again!");
			}
		}
		return string;
	}

	/**
	 * force user input exactly number
	 * 
	 * @param mess
	 * @param min
	 * @param max
	 * @return
	 */
	public int getChoice(String mess, int min, int max) {
		int number = 0;
		while (true) {
			try {
				System.out.print(mess);
				number = Integer.parseInt(sc.nextLine());
				if (number < min || number > max) {
					System.out.println("Choice within 1-5, please input again");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid number, please input again");
			}
		}
		return number;
	}

	/**
	 * get exactly Male or Female from user
	 * 
	 * @param mess
	 * @return
	 */
	public String inputGender(String mess) {
		String gender;
		while (true) {
			System.out.print(mess);
			gender = sc.nextLine();
			if (gender.trim().equalsIgnoreCase("Male") || gender.trim().equalsIgnoreCase("Female")) {
				break;
			} else {
				System.out.println("Invalid input, please enter again!");
			}
		}
		return gender;
	}

	/**
	 * get phone from user
	 * 
	 * @param mess
	 * @return
	 */
	public String inputPhoneNumber(String mess) {
		String phone;
		while (true) {
			System.out.print(mess);
			phone = sc.nextLine();
			if (phone.trim().matches(PHONE_VALID)) {
				break;
			} else {
				System.out.println("Invalid phone number, please enter again!");
			}
		}
		return phone;
	}

	/**
	 * get an email from user
	 * 
	 * @param mess
	 * @return
	 */
	public String inputMail(String mess) {
		String mail;
		while (true) {
			System.out.print(mess);
			mail = sc.nextLine().toLowerCase();
			if (mail.trim().matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
				break;
			} else {
				System.out.println("Invalid email format, please enter again!");
			}
		}
		return mail;
	}

	/**
	 * get Salary from user
	 * 
	 * @param mess
	 * @return
	 */
	public double inputSalary(String mess) {
		Scanner sc = new Scanner(System.in);
		double number;
		while (true) {
			try {
				System.out.print(mess);
				number = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid input, please enter again!");
			}
		}
		return number;
	}

	/**
	 * get valid date
	 * 
	 * @param mess
	 * @return
	 */
	  public Date inputDate(String mess) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = null;
	        Scanner sc = new Scanner(System.in);
	        sdf.setLenient(false);//Quy chuan date
	        String value = "";
	        while (true) {
	            try {
	                System.out.print(mess);
	                value = sc.nextLine();
	                date = sdf.parse(value);
	                //xu ly nhap ko qua voi ngay nhap hien tai
	                Date now = new Date();
	                if (date.after(now)) {
	                    System.out.println("The date you entered is greater than the current date");
	                    continue;
	                }
	                if (date.before(now) && (date.getYear() > now.getYear() - 13)) {
	                    System.out.println("Not enough age to work");
	                    continue;
	                }
	                break;

	            } catch (Exception e) {
	                System.out.println("Date invalid");
	            }
	        }
	        return date;
	    }
	/**
	 * get Yes No
	 * 
	 * @param mess
	 * @return
	 */
	public String getYN(String mess) {
		Scanner sc = new Scanner(System.in);
		String txt = "";
		while (true) {
			System.out.print(mess);
			txt = sc.nextLine();
			if (txt.trim().matches("[ynYN]")) {
				break;
			} else {
				System.out.println("Must input Y/N only");
			}
		}
		return txt;
	}

}
