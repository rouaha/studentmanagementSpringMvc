package abi.service;

import abi.entity.Role;
import abi.entity.User;
import abi.model.UserDetailsModel;
import abi.repository.UserRepo;

import abi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by BS190 on 7/9/2017.
 */

@Component("customerService")
public class CustomerService implements UserDetailsService {


//@Autowired
//private UserRepository userRepository;
    @Bean
     UserRepository userRepository(){
        return  new UserRepository() {
        };
    }

     @Bean User getu(){
            Set<Role> setrole= new HashSet<>();
            setrole.add(new Role("ROLE_ADMIN"));
            return new User(1,"email","admin","l","123",1, setrole);
     }



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user =  getu();

                //userRepository().findByUserName(userName);
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


}
