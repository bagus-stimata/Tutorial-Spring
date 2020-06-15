package com.example.springbootsecurity1basic.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //Tidak bisa digunakan pada Vaadin
public class BasicConfiguration extends WebSecurityConfigurerAdapter {


    // /*
    // Ini akan melakukan permit all kepada semua
    // */
    // // @Override  
    // // protected void configure(HttpSecurity http) throws Exception {
    // //     http.authorizeRequests().anyRequest().permitAll();          
    // // }
    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Override
	protected void configure(HttpSecurity http) throws Exception {
        http
            /**
             *  dengan menggunakan metode/konsep csrf yang digunakan pada controller 
             *  akan dapat mengamankan aplikasi. metode ini seperti halnya Outh2 yang dipasang
             *  pada controller
             * 
             * Khusus untuk vaadin .csrf harus di dsable
             */
            // .csrf().disable()
            //If you are using rest try to use this
            .httpBasic()
            .and()

			.authorizeRequests()
                // .antMatchers( "/**" ).permitAll() // Untuk pMelakukan Permit kepada semua dan tidak perlu otorisasi: Mengacu pada contoh diatas
                // .antMatchers( "/", "/home", "resources/**", "/registration" ).permitAll() // daftar un-secure page
                .antMatchers(
                    "/",
                    "/js/**",
                    "/css/**",
                    "/img/**",
                    // "/employee",
                    "/webjars/**", "/registration").permitAll()

                /**
                 * Menggunakan pasangan
                 * - @EnableGlobalMethodSecurity(prePostEnabled = true) dan 
                 * - @PreAuthorize("hasAnyRole('USER')")
                 *  Juga bisa
                 */
                // .antMatchers("/admin-view").hasRole("ADMIN")
                // .antMatchers("/user-view").hasAnyRole("USER", "USER")

                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll() 
                .anyRequest().authenticated()
			.and()
			.formLogin() //Jika un-autorize akan di redirct ke /login 
                .loginPage("/login")
                .failureUrl("/login?error=1")
                .defaultSuccessUrl("/home")
				.permitAll()
			.and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            .and()
            .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
                
    }
    



    // @Autowired
    // private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
 
    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.inMemoryAuthentication()
    //       .withUser("user").password(passwordEncoder().encode("user")).authorities("ROLE_USER")
    //       .and()
    //       .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");    
    // }

 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
          .withUser("user")
            .password(passwordEncoder().encode("user"))
            .roles("USER", "USER")
          .and()
          .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
