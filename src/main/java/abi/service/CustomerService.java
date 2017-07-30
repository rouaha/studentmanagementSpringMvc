package abi.service;

import abi.entity.Role;
import abi.entity.User;
import abi.entity.UserTempPassData;
import abi.model.RegiUserModel;

import abi.model.RoleModel;
import abi.repository.UserRepository;
import abi.repository.UserTempPassRepository;
import com.sun.deploy.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.*;

/**
 * Created by BS190 on 7/9/2017.
 */

//@Component("customerService")
    @Component
public class CustomerService implements UserDetailsService {
    @Autowired
    private UserTempPassRepository userTempPassRepository;

@Autowired
 private UserRepository userRepository;
   /*
    @Bean
     UserRepository userRepository(){
        return  new UserRepository() {
        };
    }*/
/*
     @Bean User getu(){
            Set<Role> setrole= new HashSet<>();
            setrole.add(new Role("ROLE_ADMIN"));
            return new User(1,"email","admin","l","123",1, setrole);
     }
*/


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user =
                //getu();

               userRepository.findByUserName(userName);
      if(user!=null){

        //  return new UserDetailsModel(user);}

     List<GrantedAuthority> authorities= buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user,authorities);}
        return null;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
     return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),
             true,true,true,true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {
     Set<GrantedAuthority> setAuth= new HashSet<>();

     for (Role role:roles){
         setAuth.add(new SimpleGrantedAuthority(role.getRole()));
     }
        List<GrantedAuthority> listAuth=new ArrayList<>(setAuth);
        return listAuth;
    }
    /*
    fetch user data ----
     */

    public RegiUserModel getUserDetails(String userName){
        RegiUserModel regiUserModel = new RegiUserModel();
        User user = userRepository.findByUserName(userName);
        if (user!=null){
            regiUserModel.setUserId(user.getUserId());
            regiUserModel.setEmail(user.getEmail());
            regiUserModel.setName(user.getName());
            Set<RoleModel> roleModels = new HashSet<>();
            for (Role role:user.getRoles()) {
                RoleModel roleModel = new RoleModel();
                roleModel.setRole(role.getRole());
                roleModels.add(roleModel);

            }
            regiUserModel.setRoles(roleModels);


        }
        return regiUserModel;
    }

    public void createUser(RegiUserModel regiUserModel) {
        User user = new User();
        if (regiUserModel != null) {
            if (regiUserModel.getUserId() >= 0) {
                user.setUserId(regiUserModel.getUserId());
            }
            if (org.springframework.util.StringUtils.hasText(regiUserModel.getLastName())) {
                user.setLastName(regiUserModel.getLastName());
            }
            if (org.springframework.util.StringUtils.hasText(regiUserModel.getName())) {
                user.setName(regiUserModel.getName());
            }
            if (org.springframework.util.StringUtils.hasText(regiUserModel.getEmail())) {
                user.setEmail(regiUserModel.getEmail());
            }
            if (org.springframework.util.StringUtils.hasText(regiUserModel.getPassword())) {
                user.setPassword(regiUserModel.getPassword());
            }
            user.setActive(regiUserModel.getActive());


            Set<Role> roles = new HashSet<>();
            for (RoleModel roleModel : regiUserModel.getRoles()) {
                Role role = new Role();
               /* if(regiUserModel.getRoles()!=null) {
                    role.setRole(roleModel.getRole());
                }*/
                role.setRole("ROLE_ADMIN");
                roles.add(role);
                role.setUser(user);
            }


            user.setRoles(roles);
            userRepository.createRegiUser(user);
        }
    }

    public String getUserDetailsForForgetPass(RegiUserModel regiUserModel) {
        String lastName = regiUserModel.getLastName();
        String email = regiUserModel.getEmail();
        User user = userRepository.getUserDataForForgetPass(lastName, email);
        String tempPass = "";
        if (user != null) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getLastName().equalsIgnoreCase(lastName)) {
                UserTempPassData userTempPassData = new UserTempPassData();
                SecureRandom random = new SecureRandom();
                long num = (int) (random.nextInt(100000) + user.getUserId());
                tempPass = String.format("%05d", num);
                //tempPass = "12345";
                userTempPassData.setUserId(user.getUserId());
                userTempPassData.setUserEmail(user.getEmail());
                userTempPassData.setUserTempPass(tempPass);
                try {
                    userTempPassRepository.create(userTempPassData);
                    return tempPass;
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
        return "Invalid Details ";

    }

    public void resetPassForForgetPass(UserTempPassData userTempPassData) {

        UserTempPassData tempPassData = userTempPassRepository
                .getForgetPassDetailsByTempPassword(userTempPassData.getUserTempPass());
        if (tempPassData != null) {
            User user = userRepository.findByEmail(tempPassData.getUserEmail());

            user.setPassword(userTempPassData.getUserNewpass());
            userRepository.createRegiUser(user);
            //userTempPassRepository.deleteById(tempPassData.getUserId());
            userTempPassRepository.deleteByUserId(tempPassData.getUserId());



        }


    }
}
