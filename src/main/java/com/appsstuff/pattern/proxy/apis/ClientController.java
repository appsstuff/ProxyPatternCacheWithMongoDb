package com.appsstuff.pattern.proxy.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsstuff.pattern.proxy.domian.Book;
import com.appsstuff.pattern.proxy.domian.BookLibrary;
import com.appsstuff.pattern.proxy.service.DownloadBookProxy;

@RestController
public class ClientController {

	@Autowired
	private BookLibrary downloadBookProxy;
	
	@RequestMapping(value = "/download")
	public ResponseEntity<?> downloadBook(@RequestParam ("isbn") String isbn){
		Book book = downloadBookProxy.downloadBook(isbn);	
		System.out.println(book);
		return new ResponseEntity<Book>(book , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clear")
	public ResponseEntity<?> clearCacheStore(){
		downloadBookProxy.clearCacheStore();
		return new ResponseEntity<String>("Cache cleared" , HttpStatus.OK);
	}
}
