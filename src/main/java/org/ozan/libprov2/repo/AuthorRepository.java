package org.ozan.libprov2.repo;

import org.bson.types.ObjectId;
import org.ozan.libprov2.models.Author;
import org.ozan.libprov2.models.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
	
	  Author findBy_id(ObjectId _id);
}
