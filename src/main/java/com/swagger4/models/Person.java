package com.swagger4.models;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Person {
    
    private final UUID uuid;
    private final String name;

    public Person(UUID uuid,
                  String name){
        
        this.uuid = uuid;
        this.name = name;
        
    }

}
