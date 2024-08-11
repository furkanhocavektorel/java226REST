package com.vektorel.restful.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vektorel.restful.exception.AllException;
import com.vektorel.restful.exception.custom.TokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class JWTManager {

    @Value("${benimmetnim.secret-key}")
    String hashKey;

    public Optional<String> createToken(Long id){

        String token="";
        Long expiresTime= 1000*60*60l;

        try {

            token= JWT.create()
                    .withClaim("id",id)
                    .withClaim("sirket","vektorel")
                    .withClaim("not","ne istersen ekle")
                    .withClaim("mail","furkan@gmail.com")
                    .withIssuer("vektorel")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+expiresTime))
                    .sign(Algorithm.HMAC512(hashKey));
            return Optional.of(token);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("---- TOKEN OLUSTURULAMADI HATAAA------");
            return Optional.of(token);
        }

    }

    public Optional<Long> getIdByToken(String token){

        try {
            Algorithm algorithm= Algorithm.HMAC512(hashKey);
            JWTVerifier jwtVerifier=JWT.require(algorithm).withIssuer("vektorel").build();

            DecodedJWT decodedJWT= jwtVerifier.verify(token);

            if (decodedJWT==null){
                //return Optional.empty();
                throw new TokenException(AllException.TOKEN_HATASI);
            }
            Optional<Long> id= Optional.of(decodedJWT.getClaim("id").asLong());

            return id;

        }catch (Exception e){
            System.out.println("---- TOKEN OLUSTURULAMADI HATAAA------");
            throw new TokenException(AllException.TOKEN_HATASI);
        }

    }




}
