package com.paras.FreeAPIs.servicesImpl;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.DTO.TodoRequestDTO;
import com.paras.FreeAPIs.entities.Todo;
import com.paras.FreeAPIs.repositories.TodoRepository;
import com.paras.FreeAPIs.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public ResponseDTO getTodos (Map<String, String> complete) {
        if (complete.containsKey("complete")) {
            List<Todo> todos = todoRepository.findByIsComplete(Boolean.parseBoolean(complete.get("complete")));
            return ResponseDTO.success("Todos fetched successfully", todos);
        }
        List<Todo> todos = todoRepository.findAll();
        return ResponseDTO.success("Todos fetched successfully", todos);
    }

    public ResponseDTO addTodo (TodoRequestDTO todoRequestDTO) {
        Todo todo = Todo.builder()
                        .title(todoRequestDTO.title())
                        .description(todoRequestDTO.description())
                        .isComplete(false)
                        .build();
        todoRepository.save(todo);
        return ResponseDTO.success("Todo added successfully", todo);
    }

    public ResponseDTO getTodoById (String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return ResponseDTO.success("Todo fetched successfully", todo.get());
        }
        return ResponseDTO.error("Todo not found", "Todo with id " + id + " not found");
    }

    public ResponseDTO updateTodo (String id, TodoRequestDTO todoRequestDTO) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setTitle(todoRequestDTO.title());
            todo.setDescription(todoRequestDTO.description());
            todoRepository.save(todo);
            return ResponseDTO.success("Todo updated successfully", todo);
        }
        return ResponseDTO.error("Todo not found", "Todo with id " + id + " not found");
    }

    public ResponseDTO deleteTodo (String id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            todoRepository.delete(todoOptional.get());
            Map<String, Object> deletedTodo = Map.of("deletedTodo", todoOptional.get());
            return ResponseDTO.success("Todo deleted successfully", deletedTodo);
        }
        return ResponseDTO.error("Todo not found", "Todo with id " + id + " not found");
    }

    public ResponseDTO toggleTodoStatus (String id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setIsComplete(!todo.getIsComplete());
            todoRepository.save(todo);
            return ResponseDTO.success("Todo status toggled successfully", todo);
        }
        return ResponseDTO.error("Todo not found", "Todo with id " + id + " not found");
    }
}
