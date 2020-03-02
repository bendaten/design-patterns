package com.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BookStore {

	private String name;
	private String address;
	private List<Book> books;

	public BookStore(String name, String address) {
		this.name = name;
		this.address = address;
		this.books = new ArrayList<>();
	}

	public BookStore(String name, String address, BookStore that) {
		this.name = name;
		this.address = address;
		this.books = new ArrayList<>();
		for (Book book : that.books) {
			this.books.add(new Book(book));
		}
	}

	/**
	 * this simulates loading the data from the database which may take a long time. we don't want to repeat this
	 * for each store we are creating - therefore it is preferable to use the copy constructor above and create
	 * stores from a prototype, for which we run loadData once.
	 */
	public void loadData() {
		for (int i = 0; i < 10; i++) {
			this.books.add(new Book(10000+i+1, "Book "+(i+1), "Author "+(i+1)));
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Book Store:\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  address: ").append(address).append("\n").append("  books:\n");
		for (Book book : books) {
			sb.append("    ").append(book.toString()).append("\n");
		}
		return sb.toString();
	}
}
