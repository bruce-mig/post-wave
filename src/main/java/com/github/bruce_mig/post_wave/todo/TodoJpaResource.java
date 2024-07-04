package com.github.bruce_mig.post_wave.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TodoJpaResource {

    public final TodoRepository todoRepository;

    public TodoJpaResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public  ResponseEntity<List<Todo>> retrieveTodos(@PathVariable String username){
        return new ResponseEntity<>(todoRepository.findByUsername(username), HttpStatus.OK) ;
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable int id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo not found with id: " + id));
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id){
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }

}
