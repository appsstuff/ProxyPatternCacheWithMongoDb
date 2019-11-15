package com.appsstuff.pattern.proxy.domian;

public interface BookLibrary {

	Book downloadBook(String isbn);
	void clearCacheStore();

}
