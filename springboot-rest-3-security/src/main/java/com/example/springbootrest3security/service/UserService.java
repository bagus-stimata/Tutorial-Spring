package com.example.springbootrest3security.service;

import java.util.Collection;

import com.example.springbootrest3security.model.FUser;



/**
 * The UserService interface
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
public interface UserService {

    FUser save(FUser user);

    Boolean delete(int id);

    FUser update(FUser user);

    FUser findById(int id);

    FUser findByUsername(String username);

    FUser findByEmail(String email);

    Collection<FUser> findAll();
}
