package com.example.springbootrest3security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.example.springbootrest3security.jpa_repository.UsersRepository;
import com.example.springbootrest3security.model.FUser;

import java.util.Collection;
import java.util.Optional;

/**
 * The UserServiceImpl class
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public FUser save(FUser user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public FUser update(FUser user) {
        return userRepository.save(user);
    }

    @Override
    public FUser findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public FUser findByUsername(String username) {
        Optional<FUser> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }else {
            return null;
        }
    }

    @Override
    public FUser findByEmail(String email) {
        Optional<FUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }else {
            return null;
        }
    }

    @Override
    public Collection<FUser> findAll() {
        Iterable<FUser> itr = userRepository.findAll();
        return (Collection<FUser>) itr;
    }
}
