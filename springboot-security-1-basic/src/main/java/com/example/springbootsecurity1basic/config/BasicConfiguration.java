package com.example.springbootsecurity1basic.config;

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
// @EnableGlobalMethodSecurity(prePostEnabled = true)
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
			.authorizeRequests()
                .antMatchers( "/**" ).permitAll() // Untuk pMelakukan Permit kepada semua dan tidak perlu otorisasi: Mengacu pada contoh diatas
                // .antMatchers( "/", "/home", "resources/**", "/registration" ).permitAll() // daftar un-secure page
                // .antMatchers(
                //     "/",
                //     "/js/**",
                //     "/css/**",
                //     "/img/**",
                //     "/webjars/**", "/registration").permitAll()

                .antMatchers("/admin").hasRole("ADMIN_ROLE")
                .antMatchers("/user").hasAnyRole("USER_ROLE", "ADMIN_ROLE")
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
            .roles("USER_ROLE", "AHMAD_ROLE")
          .and()
          .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("USER_ROLE", "ADMIN_ROLE");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
