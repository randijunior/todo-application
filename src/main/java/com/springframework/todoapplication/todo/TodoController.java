package com.springframework.todoapplication.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	private final TodoService todoService;
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.todoService.create(todo));
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> findAll() {
		return ResponseEntity.ok(todoService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, 
			@PathVariable Integer id) {
		Todo updatedTodo = todoService.update(todo, id);
		if (updatedTodo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedTodo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTodo(@PathVariable Integer id) {
		todoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
