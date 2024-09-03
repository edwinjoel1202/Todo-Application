/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwin.todo.service;
import com.edwin.todo.model.todo;
import com.edwin.todo.repository.todoRepository;
import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edwin
 */

@Service
public class todoService {
   
    @Autowired
    private todoRepository todoRepo;
    
    public Iterable<todo> getAll() {
        return todoRepo.findAll();
    }
    
    public Optional<todo> getById(Long id) {
        return todoRepo.findById(id);
    }
    
    public todo save(todo todoItem){
        if(todoItem.getId() == null)
            todoItem.setCreatedAt(Instant.now());
        todoItem.setUpdatedAt(Instant.now());
        return todoRepo.save(todoItem);
    }
    
    public void delete(todo todoItem) {
        todoRepo.delete(todoItem);
    }
    
}
