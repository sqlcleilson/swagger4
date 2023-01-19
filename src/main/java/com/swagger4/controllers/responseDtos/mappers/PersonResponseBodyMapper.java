package com.swagger4.controllers.responseDtos.mappers;

import com.swagger4.controllers.responseDtos.PersonResponseBody;
import com.swagger4.models.Person;

public class PersonResponseBodyMapper {
    
    public static PersonResponseBody fromPerson(Person person) {
        return new PersonResponseBody(
                person.getUuid().toString(),
                person.getName()
        );
    }
}
