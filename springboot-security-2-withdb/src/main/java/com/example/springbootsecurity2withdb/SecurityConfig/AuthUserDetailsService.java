package com.example.springbootsecurity2withdb.SecurityConfig;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootsecurity2withdb.model.FUser;
import com.example.springbootsecurity2withdb.model.FUserRoles;
import com.example.springbootsecurity2withdb.service.UserService;

/**
 *  Ini akan disamngkan dengan spring security SystemConfiguration
 */
@Service
public class AuthUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AuthUserDetailsService.class);

    // @Autowired
    // private UserService userService;
    @Autowired
    private UserService userService;

    private org.springframework.security.core.userdetails.User springUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        FUser user = getUserDetail(username);
        if (user != null) {
            springUser = new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(user)
                    // getAuthorities(user.getFuserRoles())
            );
            return springUser;
        } else {
            springUser = new org.springframework.security.core.userdetails.User("empty",
                    "empty",
                    false,
                    true,
                    true,
                    false,
                    getAuthorities(3)
            );
            return springUser;
        }
    }


    public List<GrantedAuthority> getAuthorities(Integer role) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (role == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role == 3) {
            authList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
        }

        return authList;
    }

    public List<GrantedAuthority> getAuthorities(FUser fuser) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        for (FUserRoles userRole: fuser.getFuserRoles()) {
            authList.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRoleID()));
        }
       
        return authList;
    }

    private FUser getUserDetail(String username) {
        FUser user = userService.findByUsername(username);
        if (user == null) {
            logger.warn("user '" + username + "' on null!");
        } else {
            logger.info(user.toString());
        }
        return user;
    }
}
