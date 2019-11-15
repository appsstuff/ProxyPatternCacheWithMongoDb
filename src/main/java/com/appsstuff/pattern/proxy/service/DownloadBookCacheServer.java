package com.appsstuff.pattern.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsstuff.pattern.proxy.apis.BookNotFoundException;
import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookLibrary;
import com.appsstuff.pattern.proxy.repo.BookMongoRepo;

@Component
public class DownloadBookCacheServer implements BookLibrary {

	@Autowired
	private BookMongoRepo bookRepos;
	
	@Override
	public Book downloadBook(String isbn) {
		Book book = bookRepos.findByIsbn(isbn);
		return book;
	}

	@Override
	public void clearCacheStore() {
	}

}
