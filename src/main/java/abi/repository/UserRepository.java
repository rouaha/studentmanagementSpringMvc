package abi.repository;

import abi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by BS190 on 7/11/2017.
 */
@Repository
public  class UserRepository  {
    @Autowired
    UserRepo userRepo;
    public User findByUserName(String name){

        return userRepo.findByUserName(name);
    }

    public void createRegiUser(User user) {
        userRepo.save(user);
    }

    public User getUserDataForForgetPass(String lastName, String email) {
        return userRepo.findBylastNameAndEmail(lastName, email);
    }

    public User findByEmail(String userEmail) {
        return userRepo.findByUserEmail(userEmail);
    }
}
