package abi.repository;

import abi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by BS190 on 7/11/2017.
 */

public interface UserRepo extends JpaRepository<User,Long>{
    @Query("select  us from User us where us.name= :name")
    User findByUserName(@Param("name") String name);

    @Query("select user from User user where user.lastName=:lastName and user.email=:email")
    User findBylastNameAndEmail(@Param("lastName") String lastName, @Param("email") String email);

    @Query("select user from User user where  user.email=:userEmail")
    User findByUserEmail(@Param("userEmail") String userEmail);
}

