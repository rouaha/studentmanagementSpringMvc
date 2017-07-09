package abi.repository;

import abi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;




/**
 * Created by BS190 on 7/5/2017.
 */

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("select pa from Student pa where pa.email=:emailId and pa.password=:pass")
    Student fetchStudentByEmailAndPass(@Param("emailId") String emailId, @Param("pass") String pass);


    @Query("select pa from Student pa where pa.email = :emailId")
    Student fetchStudentByEmail(@Param("emailId") String emailId);
}
