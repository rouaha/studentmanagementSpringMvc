package abi.service;

import abi.entity.Student;
import abi.model.StudentModel;
import abi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by BS190 on 7/5/2017.
 */
@Service

public class StudentService {

    @Autowired(required=true)
StudentRepository studentRepository;

    public List<StudentModel> retriveStudent() {
        List<Student> studenList = studentRepository.getStudentList();
        List<StudentModel> studentModelList = new ArrayList<>();
        if(!studenList.isEmpty()){

            for (Student student : studenList) {
                StudentModel studentModel = new StudentModel();

                studentModel.setEmail(student.getEmail());
                studentModel.setAge(student.getAge());
                studentModel.setDb(student.getDb());
                studentModel.setStudentId(student.getStudentId());
                studentModel.setSerialNo(student.getSerialNo());
                studentModel.setUserName(student.getUserName());
                studentModel.setPassword(student.getPassword());
                studentModelList.add(studentModel);

            }
            return studentModelList;
        }
        return null;
    }
    public  void createStudentByUser(StudentModel studentModel){
        Student student =new Student();
        if(studentModel.getSerialNo()!=0){
            student.setSerialNo(studentModel.getSerialNo());
        }
        if(StringUtils.hasText(studentModel.getStudentId())){
            student.setStudentId(studentModel.getStudentId());

        }else{
            Random rnd = new Random();
            long code= (0000001 + rnd.nextInt(900000));
            String studentId="01"+"103"+code+"01";
            student.setStudentId(studentId);
        }

        student.setUserName(studentModel.getUserName());
        student.setEmail(studentModel.getEmail());
        student.setPassword(studentModel.getPassword());
        student.setDb(studentModel.getDb());
        student.setAge(studentModel.getAge());



        studentRepository.addStudent(student);


    }
    public void deleteStudent(int serialNo){
        studentRepository.deleteStudent(serialNo);
    }


    public StudentModel retriveStudentByEmailandPass(String email, String pass) {

        Student student=  studentRepository.getStudentByemailandPass(email,pass);
        if(student!=null){
            StudentModel studentModel=new StudentModel();
            studentModel.setUserName(student.getUserName());
            studentModel.setEmail(student.getEmail());
            studentModel.setPassword(student.getPassword());
            studentModel.setStudentId(student.getStudentId());
            studentModel.setSerialNo(student.getSerialNo());
            studentModel.setAge(student.getAge());
            return studentModel;
        }
        return  null;
    }
    public StudentModel retriveStudentByEmail(String email) {

        Student student= studentRepository.getStudentByemail(email);

        StudentModel studentModel=new StudentModel();
        if(student!=null) {
            studentModel.setUserName(student.getUserName());
            studentModel.setEmail(student.getEmail());
            studentModel.setAge(student.getAge());

            return studentModel;
        }
        return  null;


    }

}
