package com.xworkz.book.service;

import java.util.List;

import com.xworkz.book.entity.BookEntity;

public interface BookService {
	long save(BookEntity bookEntity);

	BookEntity get(long id);

	List<BookEntity> listOfBooks();

	void update(BookEntity bookEntity, long id);

	void delete(long id);
}
