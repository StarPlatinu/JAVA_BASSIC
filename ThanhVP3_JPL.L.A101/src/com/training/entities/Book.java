package com.training.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {
	private String isbn;
	private Set<String> author;
	private String publicationPlace;
	
	public Book() {
		this.author = new HashSet<String>();
	}

	public Book(String isbn, Set<String> author, String publicationPlace, int pulibcationYear, String publisher,
			Date publicationDate) {
		super(pulibcationYear, publisher, publicationDate);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}



	@Override
	public void display() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Book{ ");
		System.out.print("Author:");
		for (String s : this.author) {
			System.out.print(s+" ");
		}
		System.out.print("isbn:" + this.isbn + ", publicationPlace:" + this.publicationPlace
				+ ", Year of publication:" + super.getPublicationYear() + ", publisher:" + super.getPublisher()
				+ ", Date of publication:" + formatter.format(super.getPublicationDate()) + "}");
		System.out.println();
	}
}
