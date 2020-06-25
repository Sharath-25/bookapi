package com.xworkz.book.dao;

import java.util.List;

import com.xworkz.book.entity.BookEntity;

public interface BookDAO {

	long save(BookEntity bookEntity);

	BookEntity get(long id);

	List<BookEntity> listOfBooks();

	void update(BookEntity bookEntity, long id);
	
	void delete(long id);
}
