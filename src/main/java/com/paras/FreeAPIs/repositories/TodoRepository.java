package com.paras.FreeAPIs.repositories;

import com.paras.FreeAPIs.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById (Long id);
}
