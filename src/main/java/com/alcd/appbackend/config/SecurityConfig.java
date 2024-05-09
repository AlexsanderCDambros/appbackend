package com.alcd.appbackend.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {
	
	private static final String[] PUBLIC_MATCHERS = {
			"/health/**",
			"/h2-console/**"
	};
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		
        http
        	.cors(cors -> cors.disable())
        	.csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers(PUBLIC_MATCHERS).permitAll()
            	.anyRequest().authenticated()
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions
                    .sameOrigin()
                )
            )
            .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .httpBasic(withDefaults());
        return http.build();
    }

}
