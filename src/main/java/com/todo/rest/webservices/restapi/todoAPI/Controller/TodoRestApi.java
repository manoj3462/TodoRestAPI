package com.todo.rest.webservices.restapi.todoAPI.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todo.rest.webservices.restapi.todoAPI.TodoHardcodedService;
import com.todo.rest.webservices.restapi.todoAPI.Entity.MainTodo;
import com.todo.rest.webservices.restapi.todoAPI.Repository.TodoJpaRepository;

@RestController
@RequestMapping("/api")
public class TodoRestApi {



	@Autowired
	private TodoJpaRepository todoJpaRepository;

	
	
	@GetMapping(value="/auth/users/{username}/")
	public List<MainTodo> getValid(@PathVariable String username){
		return todoJpaRepository.findByUsername(username);
		
	}
	
	@GetMapping(value="/users/{username}/todos")
	public List<MainTodo> getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUsername(username);
		
	}



	@PostMapping(value="/users/{username}/todos")
	public ResponseEntity<Void> createTodo(
			@PathVariable String username, @RequestBody MainTodo todo){
		
		
		todo.setUsername(username);
		MainTodo createdTodo = todoJpaRepository.save(todo);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable long id){
		
		
		todoJpaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	

	//Edit/Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	@PutMapping(value="/users/{username}/todos/{id}")
	public ResponseEntity<MainTodo> updateTodo(
			@PathVariable String username,
			@PathVariable long id, @RequestBody MainTodo todo){
		
		
		MainTodo todoUpdated = todoJpaRepository.save(todo);
		
		return new ResponseEntity<MainTodo>(todoUpdated, HttpStatus.OK);
	}
	
	
	
	
}
