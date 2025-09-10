package com.ciberspring.api.leaves_mgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // CHANGE: Allow all authenticated users (since all 5 users should access leaves)
                .requestMatchers("/leaves/**").hasAuthority("HR_LEAVES_ACCESS")
                .anyRequest().denyAll()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                    .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
                );
            return http.build();
        }

        private JwtAuthenticationConverter jwtAuthenticationConverter() {
            JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
            converter.setJwtGrantedAuthoritiesConverter(this::extractAuthorities);
            return converter;
        }

        private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
            // Extract groups from the token
            List<String> groups = jwt.getClaimAsStringList("groups");
            
            System.out.println("=== EXTRACTING AUTHORITIES FROM JWT ===");
            System.out.println("All claims: " + jwt.getClaims());
            System.out.println("Groups found: " + groups);
            
            if (groups == null || groups.isEmpty()) {
                System.out.println("No groups found in token!");
                return Collections.emptyList();
            }
            
            // Convert group names to authorities
            return groups.stream()
                .map(group -> new SimpleGrantedAuthority(group))
                .collect(Collectors.toList());
        }
    }