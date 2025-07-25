package com.code.api_gateway.routes;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

@Configuration
public class Routes {

        @Bean
        public RouteLocator authRoute(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("auth-service", r -> r
                                                .path("/auth/**")
                                                .filters(f -> f
                                                                .circuitBreaker(config -> config
                                                                                .setName("authCircuitBreaker")
                                                                                .setFallbackUri("forward:/fallback"))
                                                                .requestRateLimiter(rateLimiter -> rateLimiter
                                                                                .setRateLimiter(redisRateLimiter())
                                                                                .setKeyResolver(ipKeyResolver())
                                                                                .setStatusCode(HttpStatus.TOO_MANY_REQUESTS)))
                                                .uri("lb://auth-service"))
                                .build();
        }

        @Bean
        public RouteLocator musicCatalogRoute(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("music-catalog-service", r -> r
                                                .path("/music/**")
                                                .filters(f -> f
                                                                .circuitBreaker(config -> config
                                                                                .setName("authCircuitBreaker")
                                                                                .setFallbackUri("forward:/fallback"))
                                                                .requestRateLimiter(rateLimiter -> rateLimiter
                                                                                .setRateLimiter(redisRateLimiter())
                                                                                .setKeyResolver(ipKeyResolver())
                                                                                .setStatusCode(HttpStatus.TOO_MANY_REQUESTS)))
                                                .uri("lb://music-catalog-service"))
                                .build();
        }

        @Bean
        public RedisRateLimiter redisRateLimiter() {
                return new RedisRateLimiter(1, 10);
        }

        @Bean
        public KeyResolver ipKeyResolver() {
                return exchange -> Mono.just(
                                exchange.getRequest()
                                                .getRemoteAddress()
                                                .getAddress()
                                                .getHostAddress());
        }
}
