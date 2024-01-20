package si.masef.gestioncourier.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
// import org.springframework.security.web.SecurityFilterChain;

// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


// @Configuration
// public class SecurityConfig {
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf().disable().cors().disable(); 
    //   http.authorizeRequests(authorizeRequests ->
    //         authorizeRequests
    //             .requestMatchers(new AntPathRequestMatcher("/**"))
    //             .permitAll() // Exige une authentification
    //             .anyRequest().authenticated()
    //     )
    //     .oauth2Login()
    //     .and()
    //     .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())));
   
    //   // Assure-toi que CSRF et CORS sont désactivés pour des raisons de test.
    //   return http.build();
    // }

    // @Bean
    // public JwtDecoder jwtDecoder() {
    //     return JwtDecoders.fromIssuerLocation("http://192.168.100.5:9090/realms/masef");
    // }

    // // Bean definitions for UserDetailsService, JwtDecoder, etc.

// }


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import si.masef.gestioncourier.configuration.ErrorHandler;
import si.masef.gestioncourier.configuration.KeycloakRoleConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final ErrorHandler errorHandler;

  public SecurityConfig(final ErrorHandler errorHandler) {
    this.errorHandler = errorHandler;
  }

  @Bean
  protected SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
    http.cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(r -> r.anyRequest().authenticated())
        .exceptionHandling(e -> e.authenticationEntryPoint(errorHandler))
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .oauth2ResourceServer(
            httpSecurityOAuth2ResourceServerConfigurer ->
                httpSecurityOAuth2ResourceServerConfigurer.jwt(
                    jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtConverter())));

    return http.build();
  }

  private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtConverter() {
    final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
    return jwtAuthenticationConverter;
  }
      @Bean
    public JwtDecoder jwtDecoder() {
        // return NimbusJwtDecoder.withJwkSetUri("http://192.168.100.5:9090/realms/masef/protocol/openid-connect/certs").build();
        return JwtDecoders.fromIssuerLocation("http://192.168.100.5:9090/realms/masef");
    }
}