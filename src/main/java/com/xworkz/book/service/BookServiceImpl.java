package com.xworkz.book.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.book.dao.BookDAO;
import com.xworkz.book.entity.BookEntity;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO dao;

	public BookServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "\t object created");
	}

	@Override
	@Transactional
	public long save(BookEntity bookEntity) {
		return this.dao.save(bookEntity);
	}

	@Override
	@Transactional
	public BookEntity get(long id) {
		return this.dao.get(id);
	}

	@Override
	@Transactional
	public List<BookEntity> listOfBooks() {
		return dao.listOfBooks();
	}

	@Override
	@Transactional
	public void update(BookEntity bookEntity, long id) {
		this.dao.update(bookEntity, id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.dao.delete(id);
	}

}
