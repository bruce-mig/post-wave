package com.github.bruce_mig.post_wave.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "name","Get AWS Certified",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(++todosCount, "name","Learn DevOps",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(++todosCount, "name","Learn Full Stack Development",
                LocalDate.now().plusYears(1), false ));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.username().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
        return todo;
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.id() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.id() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.id());
        todos.add(todo);
    }
}