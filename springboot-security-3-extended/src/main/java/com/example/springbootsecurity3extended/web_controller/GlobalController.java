package com.example.springbootsecurity3extended.web_controller;

import java.util.Optional;

import com.example.springbootsecurity3extended.jpa_repository.UsersRepository;
import com.example.springbootsecurity3extended.model.FUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * The GlobalController  Class
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalController {

    @Autowired
    private UsersRepository usersRepository;

    private FUser loginUser;

    public FUser getLoginUser() {
        if (loginUser == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUser = usersRepository.findByUsername( auth.getName() );
            if (loginUser ==null) {
                loginUser = usersRepository.findByEmail( auth.getName() );
            }
        }

        return loginUser;
    }
}
