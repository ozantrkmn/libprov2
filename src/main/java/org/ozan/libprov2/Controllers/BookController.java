package org.ozan.libprov2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.validation.Valid;
import java.util.List;

import org.bson.types.ObjectId;
import org.ozan.libprov2.models.Book;
import org.ozan.libprov2.models.Publisher;
import org.ozan.libprov2.repo.BookRepository;
import org.ozan.libprov2.repo.PublisherRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/books")
public class BookController {
	

	  @Autowired
	  private BookRepository repository;
	  
	  MongoClient mongoClient = new MongoClient();
	  DB db = mongoClient.getDB( "admin" );
	  

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Book> getAllBook() {
	    return repository.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Book getBookById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyBookById(@PathVariable("id") ObjectId id, @Valid @RequestBody Book book) {
	    book.set_id(id);
	    repository.save(book);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Book createBook(@Valid @RequestBody Book book) {
	    book.set_id(ObjectId.get());
	    repository.save(book);
	    return book;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteBook(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}


