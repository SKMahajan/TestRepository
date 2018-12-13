package com.minutes.cache;

public interface BookRepository {

	Book getByIsbn(String isbn);
}
