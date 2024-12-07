package com.app.todo.repository;


import com.app.todo.model.TodoModel;
import jakarta.persistence.Id;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepo extends JpaRepository<TodoModel, Long> {


}
