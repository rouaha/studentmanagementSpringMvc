package abi.repository;

import abi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BS190 on 7/5/2017.
 */
@Component
public class StudentRepository  {
    @Autowired(required=true)
    StudentRepo studentRepo;
    public List<Student> getStudentList(){
        return (List<Student>) studentRepo.findAll();
    }
    public void addStudent(Student student){
        studentRepo.save(student);

    }
    public void deleteStudent(int id){
        studentRepo.delete(id);
    }

    public Student getStudentByemailandPass(String email, String pass) {
        return studentRepo.fetchStudentByEmailAndPass(email,pass);
    }

    public Student getStudentByemail(String email) {
        return studentRepo.fetchStudentByEmail(email);
    }

}
