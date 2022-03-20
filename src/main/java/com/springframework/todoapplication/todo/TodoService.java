package com.springframework.todoapplication.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo create(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}
	
	public Todo update(Todo todo, Integer id) {
		if(todoRepository.existsById(id)) {
			return todoRepository.save(todo);
		}
		return null;
	}
	
	public void delete(Integer id) {
		todoRepository.deleteById(id);
	}

}
