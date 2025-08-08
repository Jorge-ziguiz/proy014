package es.cic.curso25.proy014.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public UserDetailsService UserDetailsService() {
        var userAdmin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

         var user =  User.withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();        
        return new InMemoryUserDetailsManager(userAdmin,user);  
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

}
