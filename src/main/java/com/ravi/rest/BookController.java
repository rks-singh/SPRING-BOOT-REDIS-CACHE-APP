package com.ravi.rest;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.model.Book;

@RestController
public class BookController {

	private HashOperations<String,Integer,Book> hashOperations;
	
	public BookController(RedisTemplate<String, Book> redisTemplate) {
		
		this.hashOperations= redisTemplate.opsForHash();
		
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> saveBook(@RequestBody Book book){
		hashOperations.put("Book", book.getBookId(), book);
		return new ResponseEntity<>("Books Saved!!", HttpStatus.CREATED);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable Integer bookId){
		Book book = hashOperations.get("Book", bookId);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		hashOperations.delete("Book", bookId);
		return new ResponseEntity<String>("Book Deleted!!",HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<Collection<Book>> getBooks(){
		Map<Integer,Book> entries = hashOperations.entries("Book");
		Collection<Book> books = entries.values();
		return new ResponseEntity<Collection<Book>>(books,HttpStatus.OK);
	}
}
