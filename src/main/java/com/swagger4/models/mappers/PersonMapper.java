package com.swagger4.models.mappers;

import com.swagger4.models.Person;
import com.swagger4.models.daos.PersonDao;

public class PersonMapper {

    public static Person toPerson(PersonDao eventDao) {
        return new Person(
                eventDao.getUuid(),
                eventDao.getName()
        );
    }
    
}
