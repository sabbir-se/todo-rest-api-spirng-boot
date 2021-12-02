package com.assignment.todo.service;

import com.assignment.todo.exception.CustomException;
import com.assignment.todo.model.Todo;
import com.assignment.todo.repo.TodoRepository;
import com.assignment.todo.util.Constant;
import com.assignment.todo.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sabbir on 11/26/21.
 */

@Service
public class TodoService {

    private static final Logger logger = LoggerFactory.getLogger(TodoService.class.getName());

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        logger.info("## Get All Todo List Priority Wise ##");
        return todoRepository.findTodoListByOrderByPriorityDesc();
    }

    public Todo getTodo(Long todoID) throws CustomException {
        logger.info("## Get Specific Todo By ID ##");
        Todo findTodo = todoRepository.findTodoById(todoID);
        if (null == findTodo) {
            logger.info("# Not Found #");
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constant.TODO_NOT_FOUND);
        }
        return todoRepository.findTodoById(todoID);
    }

    public Todo todoDone(Long todoID) throws CustomException {
        logger.info("## Todo Done By ID ##");
        Todo findTodo = todoRepository.findTodoById(todoID);
        if (null == findTodo) {
            logger.info("# Not Found #");
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constant.TODO_NOT_FOUND);
        }
        findTodo.setStatus(Constant.DONE_STATUS);
        return todoRepository.save(findTodo);
    }

    public Todo saveTodo(Todo todo) throws CustomException {
        logger.info("## Create Todo ##");
        validateTodo(todo);
        if (todoRepository.findTodoByTitle(todo.getTitle()) != null) {
            logger.info("# This todo already exist #");
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), Constant.TODO_ALREADY_EXIST);
        }
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) throws CustomException {
        logger.info("## Update Todo ##");
        Todo findTodo = todoRepository.findTodoById(todo.getId());
        if (null == findTodo) {
            logger.info("# Not Found #");
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constant.TODO_NOT_FOUND);
        }
        validateTodo(todo);
        if (!todo.getTitle().equals(findTodo.getTitle())) {
            if (todoRepository.findTodoByTitle(todo.getTitle()) != null) {
                logger.info("# This todo already exist #");
                throw new CustomException(HttpStatus.BAD_REQUEST.value(), Constant.TODO_ALREADY_EXIST);
            }
        }
        return todoRepository.save(todo);
    }

    private void validateTodo(Todo todo) throws CustomException {
        if (Utils.isNullOrEmpty(todo.getTitle())) {
            logger.info("# Title must not be null #");
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), Constant.TITLE_NOT_NULL);
        }
        if (Utils.isNullOrEmpty(todo.getDescription())) {
            logger.info("# Description must not be null #");
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), Constant.DESCRIPTION_NOT_NULL);
        }
        if (todo.getPriority() > 3 || todo.getPriority() < 1) {
            logger.info("# Priority value must be between (1-3) #");
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), Constant.PRIORITY_VALUE);
        }
        todo.setStatus(Constant.PENDING_STATUS);
    }

    public boolean deleteTodo(Long todoID) throws CustomException {
        logger.info("## Delete Todo ##");
        Todo findTodo = todoRepository.findTodoById(todoID);
        if (null == findTodo) {
            logger.info("# Not Found #");
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constant.TODO_NOT_FOUND);
        }
        todoRepository.delete(findTodo);
        return true;
    }
}
