package org.ozan.libprov2.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Book{
	
	@Id
	public ObjectId _id;
	Author author;
	Publisher publisher;
	String bookname;
	Date publishdate;
	String desc;
	
	
	public Book(ObjectId _id,Publisher publisher, Author author, String bookname, Date publishdate, String desc) {
		super();
		this._id = _id;
		this.author = author;
		this.publisher = publisher;
		this.bookname = bookname;
		this.publishdate = publishdate;
		this.desc = desc;
	}



	public Publisher getPublisher() {
		return publisher;
	}



	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}



	public String get_id() {
		return _id.toHexString();
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public Date getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	

}
