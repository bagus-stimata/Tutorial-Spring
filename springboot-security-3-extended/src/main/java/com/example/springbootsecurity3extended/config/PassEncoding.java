/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springbootsecurity3extended.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The PassEncoding class
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
public class PassEncoding {

    private static PassEncoding passEncoding = new PassEncoding();
    public BCryptPasswordEncoder passwordEncoder;

    public static PassEncoding getInstance() {
        if (passEncoding != null)
            return passEncoding;
        return new PassEncoding();
    }

    private PassEncoding() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
