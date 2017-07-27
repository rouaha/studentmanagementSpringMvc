package abi.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BS190 on 7/4/2017.
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String getHomePage(Model model,HttpServletRequest request, HttpServletResponse response)
            {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null){
            if(auth.getName().equalsIgnoreCase("anonymousUser")){

            }else{ model.addAttribute("userName", auth.getName());}
        }
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


    @RequestMapping(value = "secure/manageStudent",method = RequestMethod.GET)
    public  String manageStudent(){
        return "studentManagement";
    }


    @RequestMapping(value="/logoutSuccessful", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
    public String getForgetPage() {
        return "forgetPass";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String getResetPassPage() {
        return "resetPass";
    }
}
