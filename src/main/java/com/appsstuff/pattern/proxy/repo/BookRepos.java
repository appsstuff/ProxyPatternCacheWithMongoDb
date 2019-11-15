package com.appsstuff.pattern.proxy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsstuff.pattern.proxy.domian.Book;

@Repository
public interface BookRepos extends JpaRepository<Book, String> {
	Book findByIsbn(String isbn);
}
