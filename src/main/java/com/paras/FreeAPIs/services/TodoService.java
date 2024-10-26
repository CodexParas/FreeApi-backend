package com.paras.FreeAPIs.services;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.DTO.TodoRequestDTO;

import java.util.Map;

public interface TodoService {
    ResponseDTO getTodos (Map<String, String> complete);

    ResponseDTO addTodo (TodoRequestDTO todoRequestDTO);

    ResponseDTO getTodoById (String id);

    ResponseDTO updateTodo (String id, TodoRequestDTO todoRequestDTO);

    ResponseDTO deleteTodo (String id);

    ResponseDTO toggleTodoStatus (String id);
}
