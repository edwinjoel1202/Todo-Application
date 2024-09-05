/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwin.todo.controller;

import com.edwin.todo.service.todoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author edwin
 */

@Controller
public class HomeController {
    
    @Autowired
    private todoService todoService;
    
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoService.getAll());
        
        return modelAndView;
    }
    
    @GetMapping("/create-todo")
    public String showCreateForm() {
        return "new-todo-item";
    }
    
}
