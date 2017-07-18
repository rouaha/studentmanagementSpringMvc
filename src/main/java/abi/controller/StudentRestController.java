package abi.controller;

import abi.model.RegiUserModel;
import abi.model.StudentModel;
import abi.model.UserModel;
import abi.service.CustomerService;
import abi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by BS190 on 7/5/2017.
 */
@RestController

public class StudentRestController {
    @Autowired
    StudentService studentService;
    @Autowired
    CustomerService  customerService;


    @RequestMapping(value="secure/studentInfo", method= RequestMethod.GET,produces ="application/json")
    public List<StudentModel> getStudenttList(){

        return studentService.retriveStudent();
    }


    @RequestMapping(value="/checkEmail", method= RequestMethod.POST)
    public StudentModel getPatient(@RequestBody UserModel studentlogData){
        String checkemail=studentlogData.getEmail();

        return studentService.retriveStudentByEmail(checkemail);

    }
    @RequestMapping(value="/userDetails/{userName}",method=RequestMethod.GET)
    public RegiUserModel getUserDetails(@PathVariable("userName") String userName){
        return  customerService.getUserDetails(userName);

    }

    @RequestMapping(value="/add/createStudent", method=RequestMethod.POST)
    public void createStudent(@RequestBody  StudentModel studentInfo){

        studentService.createStudentByUser(studentInfo);
    }
    @RequestMapping(value="secure/deleteStudent/{serialNo}", method=RequestMethod.DELETE)
    public void deletePatient(@PathVariable("serialNo") int serialNo){

        studentService.deleteStudent(serialNo);
    }
    @RequestMapping(value="/secure/page",method = RequestMethod.GET)
    public String getSecure(){
        return "Secure page";
    }




}
