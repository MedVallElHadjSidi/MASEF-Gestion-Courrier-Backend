package si.masef.gestioncourier.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable(); 
      http.authorizeRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers(new AntPathRequestMatcher("/**"))
                .permitAll() // Exige une authentification
                .anyRequest().authenticated()
        )
        .oauth2Login()
        .and()
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())));
   
      // Assure-toi que CSRF et CORS sont désactivés pour des raisons de test.
      return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation("http://localhost:9090/realms/masef");
    }

    // Bean definitions for UserDetailsService, JwtDecoder, etc.

}


