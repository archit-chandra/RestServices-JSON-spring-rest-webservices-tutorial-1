package com.gemalto.com.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
    
    private Integer id;
    
    @Size(min=2)
    private String name;
    
    @Past
    private Date birthDate;
    
    public User() {
        // has to create in order to POST a new user
        // Error - "message": "Type definition error: [simple type, class com.gemalto.com.restfulwebservices.user.User]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.gemalto.com.restfulwebservices.user.User` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)\n at [Source: (PushbackInputStream); line: 2, column: 5]",
    }
    
    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
    
}
