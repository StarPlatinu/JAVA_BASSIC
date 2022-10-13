package com.training.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.training.entities.*;
import com.training.utils.Validation;

public class LibraryServices {
	private static final String STRING_VALID = "[A-Za-z\\s]+";
	private static final String ISBN = "^[0-9]{3}-[0-9]{1}-[0-9]{2}-[0-9]{4}$";
	static List<Publication> list = new ArrayList<>();
	static Validation v = new Validation();

	public void menu() {
		System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======\r\n" + "1. Add a book\r\n" + "2. Add a magazine\r\n"
				+ "3. Display books and magazines\r\n" + "4. Add author to book\r\n"
				+ "5. Display top 10 of magazines by volume\r\n" + "6. Search book by (isbn, author, publisher)\r\n"
				+ "7. Exit\r\n");
	}

	public void initData() {
		Set<String> s1 = new HashSet<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date curDate = (Date) Calendar.getInstance().getTime();
		s1.add("Linh");
		Book b1 = new Book("123-3-43-3434", s1, "Ha Noi", 2021, "Lan", curDate);
		s1.add("Duc");
		Book b2 = new Book("123-3-43-3435", s1, "Ha Noi", 2021, "Minh", curDate);
		s1.add("Hoang");
		Book b3 = new Book("123-3-43-3436", s1, "Ha Noi", 2021, "Lan", curDate);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		Magazine m1 = new Magazine("Minh", 1, 2, 2021, "Lan", curDate);
		Magazine m2 = new Magazine("Minh", 1, 2, 2021, "Duc", curDate);
		Magazine m3 = new Magazine("Hong", 1, 2, 2021, "Lan", curDate);
		list.add(m1);
		list.add(m2);
		list.add(m3);
	}

	public void addNewBook() {
		// TODO Auto-generated method stub
		while (true) {
			Set<String> authors = new HashSet<>();
			String isbn = v.inputString("Enter isbn: ", ISBN);
			int n = v.inputInt("Enter number Of author: ", 0, Integer.MAX_VALUE);
			String authorName;
			for (int i = 0; i < n; i++) {
				authorName = v.inputString("Enter author name " + (i + 1) + ": ", STRING_VALID);
				authors.add(authorName);
			}
			String publicationPlace = v.inputString("Enter publicationPlace: ", STRING_VALID);
			int publicationYear = v.inputInt("Enter publicationYear: ", 0, Integer.MAX_VALUE);
			String publisher = v.inputString("Enter publisher: ", STRING_VALID);
			Date publicationDate = v.inputDate("Enter publicationDate: ");
			Book book = new Book(isbn, authors, publicationPlace, publicationYear, publisher, publicationDate);
			list.add(book);
			System.out.println("Enter y/n to countinue or exist.");
			if (v.checkInputYN()) {
				continue;
			} else {
				break;
			}
		}
	}

	public void addNewMegagine() {
		// TODO Auto-generated method stub
		while (true) {
			String author = v.inputString("Enter author: ", STRING_VALID);
			int volumn = v.inputInt("Enter volumn: ", 0, Integer.MAX_VALUE);
			int edition = v.inputInt("Enter edition: ", 0, Integer.MAX_VALUE);
			int publicationYear = v.inputInt("Enter publicationYear: ", 0, Integer.MAX_VALUE);
			String publisher = v.inputString("Enter publisher: ", STRING_VALID);
			Date publicationDate = v.inputDate("Enter publicationDate: ");
			Magazine magazine = new Magazine(author, volumn, edition, publicationYear, publisher, publicationDate);
			list.add(magazine);
			System.out.println("Enter y/n to countinue or exist.");
			if (v.checkInputYN()) {
				continue;
			} else {
				break;
			}
		}
	}

	public void displayAll() {
		if (list.isEmpty()) {
			System.out.println("Don't hava data to display.");
			return;
		}
		Set<Publication> check = new HashSet<>();
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getPublicationYear() == list.get(j).getPublicationYear()
						&& list.get(i).getPublisher().equals(list.get(j).getPublisher())) {
					check.add(list.get(j));
				}
			}
		}
		for (Publication publication : check) {
			publication.display();
		}
	}

	public void addAuthor() {
		if (list.isEmpty()) {
			System.out.println("Don't hava data to display.");
			return;
		}
		// TODO Auto-generated method stub
		String isbn = v.inputString("Enter isbn:", ISBN);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Book) {
				if (((Book) list.get(i)).getIsbn().equalsIgnoreCase(isbn)) {
					String author = v.inputString("Enter author: ", STRING_VALID);
					if (!((Book) list.get(i)).getAuthor().contains(author)) {
						((Book) list.get(i)).getAuthor().add(author);
						System.out.println("Add successfully");
						return;
					} else {
						System.out.println("Author existed");
						return;
					}
				}
			}
		}
	}

	public void displayTop10() {
		if (list.isEmpty()) {
			System.out.println("Don't hava data to display.");
			return;
		}
		List<Magazine> megagines = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Magazine) {
				megagines.add((Magazine) list.get(i));
			}
		}
		Collections.sort(megagines);
		int flag = 0;
		for (int i = 0; i < megagines.size(); i++) {
			if (flag > 10) {
				return;
			}
			megagines.get(i).display();
			flag++;
		}
	}

	public void search() {
		if (list.isEmpty()) {
			System.out.println("Don't hava data to search.");
			return;
		}
		// TODO Auto-generated method stub

		while (true) {
			System.out.println("1. search book by isbn");
			System.out.println("2. search book by author");
			System.out.println("3. search book by publisher");
			int choise = v.inputInt("Enter your choise: ", 1, 3);
			switch (choise) {
			case 1:
				String isbn = v.inputString("Enter isbn: ", ISBN);
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) instanceof Book) {
						if (((Book) list.get(i)).getIsbn().equalsIgnoreCase(isbn)) {
							((Book) list.get(i)).display();
						}
					}
				}
				break;
			case 2:
				String author = v.inputString("Enter author: ", STRING_VALID);
				int flag = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) instanceof Book) {
						for (String s : (((Book) list.get(i)).getAuthor())) {
							if (s.equalsIgnoreCase(author)) {
								((Book) list.get(i)).display();
								flag++;
							}
						}
						if (flag == 0) {
							System.out.println("Author dosn't exist.");
						}
					}
				}
				break;
			case 3:
				String publisher = v.inputString("Enter publisher: ", STRING_VALID);
				for (Publication element : list) {
					{
						if (element.getPublisher().equalsIgnoreCase(publisher)) {
							element.display();
						}
					}			
				}			
				break;			
			}
			System.out.println("Do you want to exit(y/n)?");
			if(v.checkInputYN()) {
				return;
			}
		}
	}
}
