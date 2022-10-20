package com.seal.api.gwf.authorization.ecrytion;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class CryptionServiceImpl implements CryptionService {

    private static final String AES_KEY = "AES for FWapp-gig";
    private static final String secret_key="FWApp-gig";

    @Override
    public String encrypt(String data) {
        AES aes = new AES(AES_KEY);
        return aes.encrypt(data);
    }

    @Override
    public String decrypt(String data) {
        AES aes = new AES(AES_KEY);
        return aes.decrypt(data);
    }

    // lets create class called AES

    private class AES {

        private SecretKeySpec secretKey;
        private byte[] key;

        AES(String secret) {
            MessageDigest sha = null;
            try {
                key = secret.getBytes(StandardCharsets.ISO_8859_1);
                sha = MessageDigest.getInstance("SHA-1");
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16);
                secretKey = new SecretKeySpec(key, "AES");
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String encrypt(String strToEncrypt) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return Base64.getEncoder()
                        .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.ISO_8859_1)));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        String decrypt(String strToDecrypt) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public String encode(Token token) {
        AES aes = new AES(AES_KEY);
        Claims claims = Jwts.claims();
        claims.put("id",token.getId());
        claims.put("email",token.getEmail());
        //we are encypting the userRefer using cipher
        claims.put("name",token.getName());
        claims.put("role",token.getRole());
        claims.put("picUrl",token.getPicUrl());
        claims.put("gender",token.getGender());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60*60*60*1000))
                .signWith(SignatureAlgorithm.HS512,secret_key.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    @Override
    public Token decode(String tokenSource) {
        AES aes = new AES(AES_KEY);
        Claims body=Jwts.parser()
                .setSigningKey(secret_key.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(tokenSource)
                .getBody();
        Token token= new Token();
        token.setId(Integer.parseInt(body.get("id").toString()));
        token.setEmail(String.valueOf(body.get("email")));
        token.setName(String.valueOf(body.get("name")));
        token.setRole(String.valueOf(body.get("role")));
        token.setPicUrl(String.valueOf(body.get("picUrl")));
        token.setGender(String.valueOf(body.get("gender")));
        return token;
    }

}
