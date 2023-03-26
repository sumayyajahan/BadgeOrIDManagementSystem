package com.miu.bmsapi.controller;


import com.miu.bmsapi.dto.Login;
import com.miu.bmsapi.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private RestTemplate restTemplate;

    @Value("${SIGN_IN_URI}")
    private String signinURI;


    @Autowired
    public AuthenticationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {

//        Authentication authentication = authenticationManager.
//                authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword(), new ArrayList<>()));
//        if (authentication != null) {
//            return  ResponseEntity.ok(jwtUtil.generateToken(authentication));
//        }
//        return  ResponseEntity.badRequest().body("Invalid Credentials");
//    }

        ResponseEntity<LoginResponse> response = restTemplate.exchange(signinURI, HttpMethod.POST, buildHttpEntity(login, null), LoginResponse.class);

        return response;
    }

    public static HttpEntity<?> buildHttpEntity(Object body, String token) {
        HttpHeaders headers = new HttpHeaders();
        if (null!=token) {
            headers.add("Authorization", token);
        }
        headers.add("Content-Type", "application/json");
        HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);
        return httpEntity;
    }

}
