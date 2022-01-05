package com.todo.rest.webservices.restapi.todoAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.rest.webservices.restapi.todoAPI.Entity.MainTodo;

@Repository
public interface TodoJpaRepository extends JpaRepository<MainTodo, Long>{
	List<MainTodo> findByUsername(String username);
}
