package com.minutes.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleBookRepository implements BookRepository {

	@Override
	@Cacheable("Books")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
        return new Book(isbn, "Some book");
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		}catch(InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
