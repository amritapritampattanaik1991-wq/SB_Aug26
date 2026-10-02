package com.example.to_do_application;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDo addTodo(ToDo todo) {

        return toDoRepository.save(todo);
    }

    public List<ToDo> getAllTodos() {

        return toDoRepository.findAll();
    }

    public ToDo getTodoById(int id) {

        return toDoRepository.findById(id)
                .orElse(null);
    }

    public ToDo updateTodo(int id, ToDo todo) {

        ToDo existingTodo = toDoRepository.findById(id)
                .orElse(null);

        if (existingTodo == null) {
            return null;
        }

        existingTodo.setTaskName(todo.getTaskName());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.isCompleted());

        return toDoRepository.save(existingTodo);
    }

    public void deleteTodo(int id) {

        toDoRepository.deleteById(id);
    }
}