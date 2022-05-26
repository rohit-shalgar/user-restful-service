package com.rohit.learnings.userrestservice.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public Integer id;
    public String name;
    public Date birthDate;

}
