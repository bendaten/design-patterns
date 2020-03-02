package com.prototype;

public class Book {

	private int isbn;
	private String title;
	private String author;

	public Book(int isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Book(Book that) {
		this.isbn = that.isbn;
		this.title = that.title;
		this.author = that.author;
	}

	@Override
	public String toString() {
		return "Book{" +
				"isbn=" + isbn +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				'}';
	}

}
