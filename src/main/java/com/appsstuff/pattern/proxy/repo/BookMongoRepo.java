package com.appsstuff.pattern.proxy.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookDocument;

@Repository
public interface BookMongoRepo extends MongoRepository<BookDocument, Integer>{

	BookDocument findByIsbn(String isbn);

}
