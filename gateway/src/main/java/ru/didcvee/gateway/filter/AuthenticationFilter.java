package ru.didcvee.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.didcvee.gateway.service.JWTUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

//    @Autowired
//    private RestTemplate template;

    @Autowired
    private JWTUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            org.springframework.http.server.reactive.ServerHttpRequest request = null;
            if (validator.isSecured.test(exchange.getRequest())) {
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
//                    // REST запрос в сервер аунтефикации
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token"+authHeader, String.class);
                    jwtUtil.validateToken(authHeader);
                    request = exchange.getRequest()
                            .mutate()
                            .header("loggedInUser", jwtUtil.extractUsername(authHeader))
                            .build();

                } catch (Exception e) {
                    System.out.println("invalid access.....!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    public static class Config {

    }



}
