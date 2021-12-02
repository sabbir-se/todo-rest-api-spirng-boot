package com.assignment.todo.controller;

import com.assignment.todo.exception.CustomException;
import com.assignment.todo.model.Todo;
import com.assignment.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sabbir on 11/26/21.
 */

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping()
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") long id) throws CustomException {
        return new ResponseEntity<>(todoService.getTodo(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/done")
    public ResponseEntity<Todo> getTodoDone(@PathVariable("id") long id) throws CustomException {
        return new ResponseEntity<>(todoService.todoDone(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) throws CustomException {
        return new ResponseEntity<>(todoService.saveTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo) throws CustomException {
        todo.setId(id);
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") long id) throws CustomException {
        return todoService.deleteTodo(id) ? new ResponseEntity<>("Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK);
    }
}
