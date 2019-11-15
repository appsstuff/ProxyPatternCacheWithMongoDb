package com.appsstuff.pattern.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsstuff.pattern.proxy.apis.BookNotFoundException;
import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookLibrary;
import com.appsstuff.pattern.proxy.repo.BookRepos;

@Component
public class DownloadBookDBServer implements BookLibrary {

	@Autowired
	private BookRepos bookRepos;
	
	@Override
	public Book downloadBook(String isbn) {
		Book book = bookRepos.findByIsbn(isbn);
		if(book==null) {
			throw new BookNotFoundException("Book ISBN not Found :" , isbn);
		}
		return book;
	}

	@Override
	public void clearCacheStore() {
		// TODO Auto-generated method stub
		
	}

}
