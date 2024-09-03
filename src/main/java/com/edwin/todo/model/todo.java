/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwin.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class todo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    
    private Boolean isComplete;
    
    private Instant createdAt;
    
    private Instant updatedAt;
    
    @Override
    public String toString(){
        return String.format("TodoItem{id = '%d', description = '%s', isComplete = '%s', createdAt = '%s', updatedAt = '%s'}",
                    id, description, isComplete, createdAt, updatedAt);
    }
    
    
}
