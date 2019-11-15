package com.appsstuff.pattern.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookDocument;
import com.appsstuff.pattern.proxy.domian.BookLibrary;
import com.appsstuff.pattern.proxy.repo.BookMongoRepo;

@Component
public class DownloadBookProxy implements BookLibrary {

//	private HashMap<String,Book> bookCacheServer = new HashMap<String,Book>();

	@Autowired
	private BookLibrary downloadBookDBServer;

	@Autowired
	private BookMongoRepo chaceServer;

	@Override
	public Book downloadBook(String isbn) {
		Book book = searchInBookCacheServer(isbn);
		if (book == null) {
			book = downloadBookDBServer.downloadBook(isbn);
			insertBookInCacheServer(book);
			book.setStoredIn("Book in Database Store");
			return book;
		}
		book.setStoredIn("Book in Cache Store");
		return book;
	}

	public void clearCacheStore() {
		chaceServer.deleteAll();
	}

	private void insertBookInCacheServer(Book book) {
		BookDocument doc = new BookDocument(book.getId(), book.getIsbn(), book);
		doc = chaceServer.save(doc);
		System.out.println(doc.getBook().getName());
		System.out.println("Book added to cache server");
	}

	private Book searchInBookCacheServer(String isbn) {
		BookDocument book = chaceServer.findByIsbn(isbn);
		if (book == null) {
			System.out.println("Book not found in cache server");
			return null;
		}
		System.out.println("Book Found in cache server");
		return book.getBook();
	}

}
