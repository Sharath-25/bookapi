package com.xworkz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.book.entity.BookEntity;
import com.xworkz.book.service.BookService;

@RestController
@CrossOrigin("http://localhost:4200")
public class BookController {

	@Autowired
	private BookService service;

	public BookController() {
		System.out.println(this.getClass().getSimpleName() + "\t object created");
	}

	@GetMapping("/api/books")
	public ResponseEntity<List<BookEntity>> listOfBooks() {
		List<BookEntity> listOfBooks = service.listOfBooks();
		return ResponseEntity.ok().body(listOfBooks);

	}

	@PostMapping("/api/book/save")
	public ResponseEntity<?> save(@RequestBody BookEntity bookEntity) {
		long id = this.service.save(bookEntity);
		return ResponseEntity.ok().body("book added into the DB with ID" + id);

	}

	@GetMapping("/api/book/{id}")
	public ResponseEntity<BookEntity> getSingleRecord(@PathVariable("id") long id) {
		BookEntity bookEntity = this.service.get(id);
		return ResponseEntity.ok().body(bookEntity);
	}

	@PutMapping("/api/book/update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody BookEntity entity) {
		this.service.update(entity, id);

		return ResponseEntity.ok().body("book updated successfully");

	}

	@DeleteMapping("/api/book/delete/{id}")
	public ResponseEntity<?> name(@PathVariable("id") long id) {
		this.service.delete(id);
		return ResponseEntity.ok().body("book has been deleted");

	}

}
