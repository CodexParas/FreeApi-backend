package com.paras.FreeAPIs.services;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.DTO.TodoRequestDTO;

public interface TodoService {
    ResponseDTO getTodos ();

    ResponseDTO addTodo (TodoRequestDTO todoRequestDTO);

    ResponseDTO getTodoById (String id);

    ResponseDTO updateTodo (String id, TodoRequestDTO todoRequestDTO);

    ResponseDTO deleteTodo (String id);

    ResponseDTO toggleTodoStatus (String id);
}
