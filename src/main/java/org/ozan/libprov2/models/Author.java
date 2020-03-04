package org.ozan.libprov2.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Author {

	@Id
	public ObjectId _id;
	String authorName;
	List<Book> books;
	
	public Author() {
}

	public Author(ObjectId _id, String authorName) {
		this._id = _id;
		this.authorName = authorName;
		books = new ArrayList<Book>();
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}

