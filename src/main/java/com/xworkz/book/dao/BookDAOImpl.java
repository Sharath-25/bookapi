package com.xworkz.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.book.entity.BookEntity;

@Component
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory factory;

	public BookDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "\t object created");
	}

	@Override
	public long save(BookEntity bookEntity) {
		return (long) factory.getCurrentSession().save(bookEntity);
	}

	@Override
	public BookEntity get(long id) {
		return this.factory.getCurrentSession().get(BookEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookEntity> listOfBooks() {
		List<BookEntity> list = factory.getCurrentSession().createQuery("from BookEntity").list();
		return list;
	}

	@Override
	public void update(BookEntity bookEntity, long id) {
		Session session = this.factory.getCurrentSession();
		BookEntity entity = session.byId(BookEntity.class).load(id);
		entity.setTitle(bookEntity.getTitle());
		entity.setAuthor(bookEntity.getAuthor());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = this.factory.getCurrentSession();
		BookEntity bookEntity = session.byId(BookEntity.class).load(id);
		session.delete(bookEntity);

	}

}
