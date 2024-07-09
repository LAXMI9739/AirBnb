package com.agoda.service;

import com.agoda.entity.AppUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithKey}")
    private String algorithKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryTime}")
    private int expiryTime;

    private final String USER_NAME="username";

    private Algorithm algorithm;

    @PostConstruct
    public void postConstruct(){
        algorithm=Algorithm.HMAC256(algorithKey);
    }
    public String generateToken(AppUser user){
        return JWT.create()
                .withClaim(USER_NAME ,user.getUsername())
                .withIssuer(issuer)
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryTime))
                .sign(algorithm);
    }

    public String getUsername(String token) {
        DecodedJWT decodedJWT = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return decodedJWT.getClaim(USER_NAME).asString();
    }
}
