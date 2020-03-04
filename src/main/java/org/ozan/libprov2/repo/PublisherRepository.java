package org.ozan.libprov2.repo;

import org.ozan.libprov2.models.Publisher;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher, String> {
	
  Publisher findBy_id(ObjectId _id);

}
