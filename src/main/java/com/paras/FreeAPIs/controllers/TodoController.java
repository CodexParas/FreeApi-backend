package com.paras.FreeAPIs.controllers;

import com.paras.FreeAPIs.DTO.ResponseDTO;
import com.paras.FreeAPIs.DTO.TodoRequestDTO;
import com.paras.FreeAPIs.services.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getTodos () {
        return ResponseEntity.ok(todoService.getTodos());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> addTodo (@Valid @RequestBody TodoRequestDTO todoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.addTodo(todoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getTodoById (@PathVariable String id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateTodo (@PathVariable String id, @Valid @RequestBody TodoRequestDTO todoRequestDTO) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTodo (@PathVariable String id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @PatchMapping("/toggle/status/{id}")
    public ResponseEntity<ResponseDTO> toggleTodoStatus (@PathVariable String id) {
        return ResponseEntity.ok(todoService.toggleTodoStatus(id));
    }
}
