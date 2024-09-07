package com.edwin.todo.controller;

import com.edwin.todo.model.todo;
import com.edwin.todo.service.todoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {

    @Autowired
    private todoService todoService;

    @GetMapping("/create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new todo());
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid todo todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-todo-item";
        }
        todoService.save(todoItem);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id){
            todo todoItem = todoService
                    .getById(id)
                    .orElseThrow(()->new IllegalArgumentException("Todo Item not found !"));
            todoService.delete(todoItem);
            return "redirect:/";        
    }
    
    
    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable("id") Long id, Model model){
        todo todoItem = todoService
                    .getById(id)
                    .orElseThrow(()->new IllegalArgumentException("Todo Item not found !"));
        
        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }
    
    
    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid todo todoItem, BindingResult result, Model model){
                todo item = todoService
                    .getById(id)
                    .orElseThrow(()->new IllegalArgumentException("Todo Item not found !"));
                
                item.setIsComplete(todoItem.getIsComplete());
                item.setDescription(todoItem.getDescription());
                
                todoService.save(item);
                
                return "redirect:/";
    }
}
