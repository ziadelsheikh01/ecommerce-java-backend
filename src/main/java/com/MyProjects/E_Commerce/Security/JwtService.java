package com.MyProjects.E_Commerce.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService
{
    private  final  String secretKey = "d5a8b9af4bf3ca4bde7748f9e1d3e826a57f82a93826963ac844588b8df2c3e1";

    public Key getKey ()
    {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


    public  String generateToken (String username)
    {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public  String extractUsername(String token)
    {
        return  Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }



    public  boolean isValidToken (String token , UserDetails userDetails)
    {
       try
       {
           Jwts.parserBuilder()
                   .setSigningKey(getKey())
                   .build()
                   .parseClaimsJws(token);
           return  extractUsername(token).equals(userDetails.getUsername()) ;
       }
       catch (Exception ex)
       {
           return  false ;
       }

    }

}
