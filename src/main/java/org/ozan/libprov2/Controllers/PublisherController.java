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
import org.ozan.libprov2.models.Publisher;
import org.ozan.libprov2.repo.PublisherRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/publishers")
public class PublisherController {
	
	

	  @Autowired
	  private PublisherRepository repository;
	  
	  MongoClient mongoClient = new MongoClient();
	  DB db = mongoClient.getDB( "admin" );
	  

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Publisher> getAllPublisher() {
	    return repository.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Publisher getPublisherById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyPublisherById(@PathVariable("id") ObjectId id, @Valid @RequestBody Publisher publisher) {
	    publisher.set_id(id);
	    repository.save(publisher);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Publisher createPublisher(@Valid @RequestBody Publisher publisher) {
	    publisher.set_id(ObjectId.get());
	    repository.save(publisher);
	    return publisher;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deletePublisher(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}


