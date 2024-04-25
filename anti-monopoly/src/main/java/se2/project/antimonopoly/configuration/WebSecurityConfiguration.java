package se2.project.antimonopoly.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain disableSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().permitAll() // Erlaubt alle Anfragen ohne Authentifizierung
                )
                .csrf().disable() // CSRF-Schutz deaktivieren, wenn dein Frontend nicht mit Spring Security interagiert
                .formLogin().disable() // Form-Login deaktivieren
                .httpBasic().disable(); // HTTP Basic Auth deaktivieren
        return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder() // NICHT für Produktionscode verwenden
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Autorisierungsanfragen konfigurieren
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/redis/ping").permitAll() // Zugriff auf /ping ohne Authentifizierung erlauben
                        .anyRequest().authenticated() // Alle anderen Anfragen erfordern Authentifizierung
                )
                // HTTP Basic Auth verwenden
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

     */
}