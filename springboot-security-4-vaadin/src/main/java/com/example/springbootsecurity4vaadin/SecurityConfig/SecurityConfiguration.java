package com.example.springbootsecurity4vaadin.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Configures spring security, doing the following:
 * <li>Bypass security checks for static resources,</li>
 * <li>Restrict access to the application, allowing only logged in users,</li>
 * <li>Set up the login form</li>

 */
@EnableWebSecurity
@Configuration
/**
 * Vaadin tidak menggunakan ini
 */
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_PROCESSING_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login";
	private static final String LOGIN_URL = "/login";
	private static final String LOGOUT_SUCCESS_URL = "/login";

	@Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;


    @Autowired
    private AuthUserDetailsService userDetailsService;

	/**
	 * Require login to access internal pages and configure login form.
	 */
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	// Not using Spring CSRF here to be able to use plain HTML for the login page
	// 	http.csrf().disable()

	// 			// Register our CustomRequestCache, that saves unauthorized access attempts, so
	// 			// the user is redirected after login.
	// 			.requestCache().requestCache(new CustomRequestCache())

	// 			// Restrict access to our application.
	// 			.and().authorizeRequests()

	// 			// Allow all flow internal requests.
	// 			.requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()

	// 			// Allow all requests by logged in users.
	// 			.anyRequest().authenticated()

	// 			// Configure the login page.
	// 			.and().formLogin().loginPage(LOGIN_URL).permitAll().loginProcessingUrl(LOGIN_PROCESSING_URL)
	// 			.failureUrl(LOGIN_FAILURE_URL)

	// 			// Configure logout
	// 			.and().logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
	// }

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
            .csrf().disable()

			.authorizeRequests()
                // .antMatchers( "/**" ).permitAll() // Untuk pMelakukan Permit kepada semua dan tidak perlu otorisasi: Mengacu pada contoh diatas
                // // .antMatchers( "/", "/home", "resources/**", "/registration" ).permitAll() // daftar un-secure page

                .antMatchers(
                    "/",
                    "/home",
                    "/js/**",
                    "/css/**",
                    "/img/**",
                    "/webjars/**", "/registration")
                .permitAll()
                    
                /**
                 * Otomatis dibaca:
                 *  ROLE_ADMIN, ROLE_USER, ROLE_ACCOUNTING
                 */

                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/task/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*", "/register/**")
                .permitAll() 
                .anyRequest().authenticated()
			.and()
			.formLogin() //Jika un-autorize akan di redirct ke /login 
                .loginPage("/login")
                .failureUrl("/login?error=1")
                // .defaultSuccessUrl("/home")
                .successHandler(successHandler) //more spesific using success handler
				.permitAll()
			.and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            .and()
            .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
                // .accessDeniedPage("/access-denied"); //this is the same
                
    }
 	
	// @Bean
	// @Override
	// public UserDetailsService userDetailsService() {
	// 	UserDetails user =
	// 			User.withUsername("user")
	// 					.password("{noop}password")
	// 					.roles("USER")
	// 					.build();

	// 	return new InMemoryUserDetailsManager(user);
	// }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(PassEncoding.getInstance().passwordEncoder());
    }    

	/**
     * Just use for  ### VAADIN FLOW ####
	 * Allows access to static resources, bypassing Spring security.
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(

				// Vaadin Flow static resources
				"/VAADIN/**",

				// // the standard favicon URI
				"/favicon.ico",

				// // the robots exclusion standard
				"/robots.txt",

				// // web application manifest
				"/manifest.webmanifest",
				"/sw.js",
				"/offline-page.html",

				// // icons and images
				"/icons/**",
				"/images/**",

				// // (development mode) static resources
				"/frontend/**",

                /**
                 * #### INI BUAT ERROR TIME STAMP YA ####
                 */
				// // (development mode) webjars
				// "/webjars/**",

				// // (development mode) H2 debugging console
				"/h2-console/**",

				// // (production mode) static resources
                "/frontend-es5/**", "/frontend-es6/**"
                
                );
	}


}
