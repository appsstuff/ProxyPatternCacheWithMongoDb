package com.appsstuff.pattern.proxy.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookLibrary;

@Component
public class DownloadBookProxy implements BookLibrary {
	
	private HashMap<String,Book> bookCacheServer = new HashMap<String,Book>();
	
	@Autowired
	private BookLibrary bownloadBookService;
	
	@Override
	public Book downloadBook(String isbn) {
		Book book = searchInBookCacheServer(isbn);
		if(book==null) {
			book = bownloadBookService.downloadBook(isbn);
			insertBookInCacheServer(book);
			book.setStoredIn("Book in Database Store");
			return book;
		}
		book.setStoredIn("Book in Cache Store");
		return book;
	}
	
	public void clearCacheStore() {
		bookCacheServer.clear();
	}

	private void insertBookInCacheServer(Book book) {
		bookCacheServer.put(book.getIsbn(), book);
		System.out.println("Book added to cache server");
	}

	private Book searchInBookCacheServer(String isbn) {
		Book book =bookCacheServer.get(isbn);
		if(book==null) {
			System.out.println("Book not found in cache server");
			return null;
		}
		System.out.println("Book Found in cache server");
		return book;
	}

}
