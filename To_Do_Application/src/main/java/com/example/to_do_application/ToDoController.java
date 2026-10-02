package com.example.to_do_application;

import java.util.List;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    // Get Todos
    @GetMapping
    public List<ToDo> getTodos() {
        return toDoService.getAllTodos();
    }

    // Get todo by id
    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable int id) {
        return toDoService.getTodoById(id);
    }

    // Create todo
    @PostMapping
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo todo) {

        ToDo savedTodo = toDoService.addTodo(todo);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Delete todo
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable int id) {

        toDoService.deleteTodo(id);
    }

    // Update todo

    @PutMapping
    public ToDo updateTodo(@RequestBody ToDo todo) {
        return toDoService.updateTodo(todo.getId(), todo);
    }

}