package com.ravi.model;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
	
	public Book() {
		
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}
