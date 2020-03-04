package org.ozan.libprov2.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Publisher {
	
	@Id
	 public ObjectId _id;
	String publishername;
	List<Book> books;
	
	public Publisher() {}



	  public Publisher(ObjectId _id, String publishername) {
		this._id = _id;
		this.publishername = publishername;
		books = new ArrayList<Book>();
	}



	public String get_id() {
		return _id.toHexString();
	}



	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public String getPublishername() {
		return publishername;
	}



	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}




}
