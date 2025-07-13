package com.wish.WishTaskManagement.TaskManagement.config.jwt;

import com.wish.WishTaskManagement.TaskManagement.exceptions.JWTExceptionHandler;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${spring.app.JWTSecret}")
    private String jwtSecret;

    public String getJWTFromHeader(HttpServletRequest httpRequest){
        String bearerToken = httpRequest.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateAccessToken(UserDetails userDetails){
        String username = userDetails.getUsername();
        return Jwts.builder().subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000L))
                .signWith(key())
                .compact();
    }

    public String generateRefreshToken(UserDetails userDetails){
        String username = userDetails.getUsername();
        return Jwts.builder().subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000L))
                .signWith(key())
                .compact();
    }

    public String getUsernameFromJwt(String token){
        return  Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(token).getPayload().getSubject();
    }


    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(authToken);
            return true;
        }catch (MalformedJwtException mex){
            logger.error("Invalid JWT Token: {}",mex.getMessage());
            throw new JWTExceptionHandler("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            logger.error("JWT token is expired {}",ex.getMessage());
            throw new JWTExceptionHandler("JWT token is expired");
        }catch (UnsupportedJwtException ex){
            logger.error("Jwt Token in Unsupported: {}",ex.getMessage());
            throw new JWTExceptionHandler("Jwt Token in Unsupported");
        }catch (IllegalArgumentException ex){
            logger.error("JWT claims string is empty {}",ex.getMessage());
            throw new JWTExceptionHandler("JWT claims string is empty");
        }
    }


    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

}
