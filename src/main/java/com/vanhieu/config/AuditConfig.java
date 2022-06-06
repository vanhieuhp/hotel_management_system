package com.vanhieu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("admin");
        }

//        @Override
//        public Optional<String> getCurrentAuditor() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//            if (authentication == null ||
//                    !authentication.isAuthenticated() ||
//                    authentication instanceof AnonymousAuthenticationToken) {
//                return Optional.empty();
//            }
//
//            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//            return Optional.of(userPrincipal.getName());
//        }
    }

}
