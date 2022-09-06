package com.springframework.todoapplication.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.springframework.todoapplication.todo.Todo;
import com.springframework.todoapplication.todo.TodoRepository;

class TodoServiceTests {
	
	private final TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

	@Test
	void createTodoWithTitle() {
		var todo = Todo.builder().id(1).title("Estudar Java").build();
		when(todoRepository.save(any(Todo.class))).thenReturn(todo);//then(returnsFirstArg());
		var savedTodo = todoRepository.save(todo);
		assertThat(savedTodo.getTitle()).isNotNull();
		assertEquals(savedTodo.getId(), 1);
		assertThat(savedTodo.getDate()).isNotNull();
	}
	
	@Test
	void listAllTodos() {
		var todoList = Arrays.asList(
				Todo.builder().id(1).title("Estudar C++").build(),
				Todo.builder().id(2).title("Estudar Java").build()
		);
		when(todoRepository.findAll()).thenReturn(todoList);
		var listTodo = todoRepository.findAll();
		assertThat(listTodo.size()).isNotZero();
	}

}
