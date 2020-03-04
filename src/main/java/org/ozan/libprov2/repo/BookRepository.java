package org.ozan.libprov2.repo;

import org.bson.types.ObjectId;
import org.ozan.libprov2.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

	Book findBy_id(ObjectId _id);
	
}
