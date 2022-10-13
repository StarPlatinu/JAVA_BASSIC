package com.training.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine extends Publication implements Comparable<Magazine> {
	private String author;
	private int volumn;
	private int edition;

	public Magazine(String author, int volumn, int edition, int pulibcationYear, String publisher,
			Date publicationDate) {
		super(pulibcationYear, publisher, publicationDate);
		this.author = author;
		this.volumn = volumn;
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public void display() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Magazine{ author:" + this.author + ", volumn:" + this.volumn + ", edition:" + this.edition
				+ ", year of publication:" + super.getPublicationYear() + ", publisher:" + super.getPublisher()
				+ ", date of publication:" + formatter.format(super.getPublicationDate()) + "}");
	}

	@Override
	public int compareTo(Magazine o) {
		if(this.getVolumn()>(o.getVolumn())) {
			return 1;
		}else if(this.getVolumn() == (o.getVolumn())) {
			return 0;
		}else {
			return -1;
		}		
	}
}
