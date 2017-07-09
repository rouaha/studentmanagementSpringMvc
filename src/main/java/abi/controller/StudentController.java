package abi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BS190 on 7/4/2017.
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String getHomePage(){
        return "home";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String getLoginPage(){
        return "signin";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public  String getRegPage(){
        return "signup";
    }

   // @RequestMapping(value = "/registration",method = RequestMethod.POST)
   // public  String userRegistration(@ModelAttribute("userregi")User userregi){

       // if (bindingResult.hasErrors())
       // {return "signup";}
      //  return  null;
   // }
    @RequestMapping(value = "/createStudent",method = RequestMethod.GET)
    public  String createStudent(){
        return "createStudent";
    }


    @RequestMapping(value = "/manageStudent",method = RequestMethod.GET)
    public  String manageStudent(){
        return "studentManagement";
    }
}
