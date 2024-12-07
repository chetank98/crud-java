package com.app.todo.service;


import com.app.todo.model.TodoModel;
import com.app.todo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    public TodoModel saveCourse(TodoModel todo){
        return todoRepo.save(todo);
    }

    public List<TodoModel> getAllCourse(){
        return (List<TodoModel>) todoRepo.findAll();
    }

    public Optional<TodoModel> getCourse(long id){
        return todoRepo.findById(id);
    }

    public Optional<TodoModel> updateCourse(long id, TodoModel updatedModel) {
        return todoRepo.findById(id).map(existingTodo -> {
            // Update fields
            existingTodo.setName(updatedModel.getName());
            existingTodo.setContent(updatedModel.getContent());
            existingTodo.setCompleted(updatedModel.getCompleted());

            // Save updated object
            return todoRepo.save(existingTodo);
        });
    }

    public void deleteCourse(long id){
        todoRepo.deleteById(id);
    }


}
