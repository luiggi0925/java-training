package day7.exercices;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout().logoutSuccessUrl("/")
                .permitAll();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }
    
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final Properties users = new Properties();
        users.put("user","pass,ROLE_USER,enabled"); 
        users.put("ilan","ilan,ROLE_USER,enabled");
        users.put("john","john,ROLE_USER,disabled"); //you wont be able to enter with this one
        users.put("super","super,ROLE_ADMIN,enabled"); //this has the privilege of deleting cases (deletion not yet implemented)
        return new InMemoryUserDetailsManager(users);
    }
    
//  @Override
// 	public void configure(AuthenticationManagerBuilder auth) throws Exception {
// 	        auth
// 	                .userDetailsService(userDetailsService)
// 	                .passwordEncoder(new BCryptPasswordEncoder());
// 	}
}