package com.randi.todolist.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springframework.todoapplication.todo.Todo;
import com.springframework.todoapplication.todo.TodoRepository;

class TodoServiceTests {
	
	private final TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

	@Test
	void createTodoWithTitle() {
		var todo = new Todo(1,"Estudar Java");
		when(todoRepository.save(any(Todo.class))).thenReturn(todo);//then(returnsFirstArg());
		var savedTodo = todoRepository.save(todo);
		assertThat(savedTodo.getTitle()).isNotNull();
		assertEquals(savedTodo.getId(), 1);
		assertThat(savedTodo.getDate()).isNotNull();
	}
	
	@Test
	void listAllTodos() {
		var todoList = Arrays.asList(new Todo(1, "Estudar C++"), 
				new Todo(2, "Estudar Java"));
		when(todoRepository.findAll()).thenReturn(todoList);
		var listTodo = todoRepository.findAll();
		assertThat(listTodo.size()).isNotZero();
	}

}
