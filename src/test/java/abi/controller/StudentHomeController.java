package abi.controller;

import abi.model.RegiUserModel;
import abi.model.StudentModel;
import abi.repository.StudentRepository;
import abi.repository.UserRepository;
import abi.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by BS190 on 7/19/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dispatcher-servlet.xml"})
@WebAppConfiguration
@Transactional
/*@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
         })*/
public class StudentHomeController {

   private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Mock
    @Autowired
    StudentRepository studentRepository;


    @InjectMocks
    @Autowired
    StudentService studentService;


    @Before
    public  void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /* @Test
     public void getHomePage_shouldRenderHomePage() throws  Exception{

         mockMvc.perform(get("/"))
                 .andExpect(status().isOk())
                 .andExpect(view().name("home"))
                 .andExpect(forwardedUrl("/WEB-INF/views/jsp/home.jsp"));
     }
     @Test
     public void testRegistrationPage()throws  Exception{
         mockMvc.perform(get("/registration"))
                 .andExpect(status().isOk())
                 .andExpect(view().name("signup"))
                 .andExpect(forwardedUrl("/WEB-INF/views/jsp/signup.jsp"));
     }
     @Test
     public void testCheckByEmail() throws Exception {
         StudentModel studentModel = new StudentModel();
        *//* studentModel.setSerialNo(28);
        studentModel.setAge("26 Years");
        studentModel.setDb("07/31/1990");

        studentModel.setPassword("123");
        studentModel.setUserName("rasel");
        studentModel.setStudentId("0110346139401");*//*
        studentModel.setEmail("rasej@gmail.com");

        StudentModel chStudentModel = studentService.retriveStudentByEmail(studentModel.getEmail());
        mockMvc.perform(post("/checkEmail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(studentModel)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.email", is(chStudentModel.getEmail())));

    }*/
/*
    @Test
    public void matchCheckMail() {
        StudentModel studentModel = studentService.retriveStudentByEmail("rasej@gmail.com");
        assertEquals("rase@gmail.com", studentModel.getEmail());

    }*/
    @Test
    public void Test_forgetSetup() throws Exception {
        RegiUserModel regiUserModel = new RegiUserModel();
        regiUserModel.setName("Abi");
        regiUserModel.setLastName("abiabdullah");
        regiUserModel.setEmail("abi@gmail.com");
        mockMvc.perform(post("/forgetPassword")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(regiUserModel)))
                .andExpect(status().isOk());
        // .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE));



    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
