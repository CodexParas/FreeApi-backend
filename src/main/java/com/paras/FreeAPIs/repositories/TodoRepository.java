package com.paras.FreeAPIs.repositories;

import com.paras.FreeAPIs.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {

    List<Todo> findByIsComplete (boolean complete);
}
