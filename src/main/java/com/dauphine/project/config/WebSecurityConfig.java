package com.dauphine.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dauphine.project.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
    String[] resources = new String[]{
            "/include/**", "/templates/**","/static/**", "*/css/**","/icons/**","/img/**","/js/**","/layer/**", "/fonts/**"
    };
    
    
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
	        .antMatchers(resources).permitAll()
	        .antMatchers("/css/**", "/js/**","/fonts/**", "/img/**", "/static/**").permitAll()
	        .antMatchers("/","/index", "/demanderDevis").permitAll()	        
	        .antMatchers("/serviceTechnique", "/consulterDevis").access("hasRole('TECH')")
                .anyRequest().authenticated()
                .and()
                
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/serviceTechnique")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
        
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	

    // Enregistrer le service pour les utilisateurs et le chiffreur de mot de passe
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
	

}