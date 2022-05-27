package com.rohit.learnings.userrestservice.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public Integer id;

    @Size(min = 2,message = "Name should be at least 2 characters long.")
    public String name;

    @Past(message = "Birth date should be in the past")
    public Date birthDate;

}
