package com.github.bruce_mig.post_wave.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    public final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username){
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable int id){
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return todo;
    }

}
