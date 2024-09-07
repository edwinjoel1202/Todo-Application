package com.edwin.todo.controller;

import com.edwin.todo.model.todo;
import com.edwin.todo.service.todoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
