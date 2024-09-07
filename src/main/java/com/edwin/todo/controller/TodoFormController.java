/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwin.todo.controller;

import ch.qos.logback.core.model.Model;
import com.edwin.todo.model.todo;
import com.edwin.todo.service.todoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author edwin
 */

@Controller
public class TodoFormController {
    
    @Autowired
    private todoService todoService;
    
    @GetMapping("/create-todo")
    public String showCreateForm() {
        return "new-todo-item";
    }
    
    @PostMapping("/todo")
    public String createTodoItem(@Valid todo todoItem, BindingResult result, Model model){
        todo item = new todo();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        
        todoService.save(todoItem);
        return "redirect:/";
    }
    
}
