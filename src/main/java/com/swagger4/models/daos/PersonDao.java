package com.swagger4.models.daos;

import java.util.UUID;

import lombok.Data;

@Data
public class PersonDao {
    private UUID uuid;
    private String name;
}
