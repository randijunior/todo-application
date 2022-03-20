package com.springframework.todoapplication.todo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull private Integer id;
	@NonNull String title;
	private LocalDate date = LocalDate.now(); 
	
}
