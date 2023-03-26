package com.miu.bmsapi.proxy;

import com.miu.bmsapi.controller.AuthenticationController;
import com.miu.bmsapi.dto.ValidateTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.resource.HttpResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class JwtFilterProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${VALIDATE_URI}")
    private String validateURI;

    @Around("execution(* com.miu.bmsapi.controller.*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Creating object to get hearers value
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
// Checking if token is present on header or not
        String token = request.getHeader("auth");
        //Checking if user is trying to login or not (If trying logging just permiting that endpoit to hit)
        if (null == token && Objects.equals(proceedingJoinPoint.getSignature().getName(), "login")) {
            try {
                return proceedingJoinPoint.proceed();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            // Checking user is trying to hit other endpoints than login
        } else if (null != token && !Objects.equals(proceedingJoinPoint.getSignature().getName(), "login")) {
            // Calling identity platform to check the user provided token is valid or not
            // If token is valid identify platform sends the ROLE and email back
            try {
                ResponseEntity<ValidateTokenResponse> response = restTemplate
                        .exchange(validateURI, HttpMethod.GET,
                                AuthenticationController.buildHttpEntity(null, "Bearer " + token), ValidateTokenResponse.class);

                if (response.hasBody()) {
                    //If the token is valid the routing user based on their roles
                    return routeRequest(proceedingJoinPoint, response);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
            }


        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    private ResponseEntity<?> routeRequest(ProceedingJoinPoint proceedingJoinPoint, ResponseEntity<ValidateTokenResponse> response) throws Throwable {

        List<String> roles = response.getBody().getRoles();
        // Allowing all endpoints if the role is ADMIN
        if (roles.contains("ROLE_ADMIN")) {
            return ResponseEntity.ok(proceedingJoinPoint.proceed());
// Allowing ROLE_CHECKER to hit only checkIn method of BadgeController
        } else if (roles.contains("ROLE_CHECKER")) {
            if (proceedingJoinPoint.getSignature().getName().equals("checkIn")) {
                return ResponseEntity.ok(proceedingJoinPoint.proceed());
            }
        }
        return ResponseEntity.badRequest().body("You don't have sufficient permission to access this endpoint");
    }

}
