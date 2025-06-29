package org.example.service;

import org.example.model.Users;

import java.util.List;

public class UsersService {

    public static Users findUserById(List<Users> users , int id){
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
