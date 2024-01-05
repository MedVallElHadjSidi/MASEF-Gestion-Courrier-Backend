package si.masef.gestioncourier.configuration;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig   {
    //    @Override
    // public void addCorsMappings(CorsRegistry registry) {
    //     registry.addMapping("/cr/**")
    //         .allowedOrigins("http://localhost:4200", "http://localhost:8080")
    //         .allowedMethods("GET", "POST", "PUT", "DELETE")
    //         .allowedHeaders("Authorization", "Content-Type")
    //         .allowCredentials(true)
    //         .maxAge(3600);
    // }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "X-Requested-With", "X-Auth-Token"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // @Bean
    // public CorsFilter corsFilter() {
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     CorsConfiguration config = new CorsConfiguration();
    //     config.setAllowCredentials(true);
    //     config.addAllowedOrigin("http://localhost:4200","http://localhost:8080/**");
    //     config.addAllowedHeader("*");
    //     config.addAllowedMethod("OPTIONS");
    //     config.addAllowedMethod("GET");
    //     config.addAllowedMethod("POST");
    //     config.addAllowedMethod("PUT");
    //     config.addAllowedMethod("DELETE");
    //     config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Utilisez setAllowedHeaders ici
    //     source.registerCorsConfiguration("/**", config);
    //     return new CorsFilter(source);
    // }
}
