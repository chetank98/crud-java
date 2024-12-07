package com.app.todo.controller;


import com.app.todo.model.TodoModel;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/createTodo")
    public TodoModel addTodo(@RequestBody TodoModel todoModel){
        return todoService.saveCourse(todoModel);
    }

    @GetMapping("/getAllCourse")
    public List<TodoModel> getAllCourse(){
        return todoService.getAllCourse();
    }

    @GetMapping("/getCourse/{id}")
    public Optional<TodoModel> getCourse(@PathVariable("id") long id) {
        return todoService.getCourse(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoModel> updateCourse(@PathVariable("id") long id, @RequestBody TodoModel updatedModel) {
        Optional<TodoModel> updatedTodo = todoService.updateCourse(id, updatedModel);
        return updatedTodo
                .map(ResponseEntity::ok) // Return 200 OK with the updated object
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 if not found
    }

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestParam("id") long id) {
        todoService.deleteCourse(id);
    }

}
