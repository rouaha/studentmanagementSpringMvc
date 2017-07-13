package abi.repository;

import abi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BS190 on 7/11/2017.
 */

public abstract class UserRepository  {
    @Autowired
    UserRepo userRepo;
    public User findByUserName(String name){

        return userRepo.findByUserName(name);
    }
}
