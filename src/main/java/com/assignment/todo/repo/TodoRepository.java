package com.assignment.todo.repo;

import com.assignment.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sabbir on 11/26/21.
 */

@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findTodoByTitle(String title);
    Todo findTodoById(Long id);
    List<Todo> findTodoListByOrderByPriorityDesc();
}
