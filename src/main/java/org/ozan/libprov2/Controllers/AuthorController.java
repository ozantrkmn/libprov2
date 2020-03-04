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
import com.mongodb.util.JSON;

import javax.validation.Valid;
import java.util.List;

import org.bson.types.ObjectId;
import org.ozan.libprov2.models.Author;
import org.ozan.libprov2.models.Publisher;
import org.ozan.libprov2.repo.AuthorRepository;
import org.ozan.libprov2.repo.PublisherRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	

	  @Autowired
	  private AuthorRepository repository;
	  
	  MongoClient mongoClient = new MongoClient();
	  DB db = mongoClient.getDB( "admin" );
	  

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Author> getAllAuthor() {
	    return repository.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Author getAuthorrById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/names/{name}", method = RequestMethod.GET)
	  public String getAuthorByname(@PathVariable("name") String name) {
		  BasicDBObject query = new BasicDBObject("authorName", name);
		  DBCollection coll = db.getCollection("author");
		  DBCursor cursor = coll.find(query);
		  DBObject theObj = null;
		  try {
		     while(cursor.hasNext()) {
		    	 theObj = cursor.next();
		     }
		  } finally {
		     cursor.close();
		  
		  }
		  	String output = JSON.serialize(cursor);
		     return output;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyAuthorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Author author) {
	    author.set_id(id);
	    repository.save(author);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Author createAuthor(@Valid @RequestBody Author author) {
	    author.set_id(ObjectId.get());
	    repository.save(author);
	    return author;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteAuthor(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}


