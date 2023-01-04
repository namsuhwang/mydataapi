package com.kpcnc.mydataapi.common;

import org.springframework.beans.factory.annotation.Value;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CommonUtil {

    @Value("${jwt.secret.signature}")
    private static String signatureKey;

    public static String getSignatureKey(){
        return signatureKey;
    }

    public static String parseWebReqParam(String str){
        String result = "";
        if (str.equalsIgnoreCase("undefined") || str.equalsIgnoreCase("null")) {
            return null;
        }
        return str;
    }


    public static boolean isNullEmpty(String str){
        boolean result;
        if(str == null || str.isBlank()){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

//    public static MemberAuthDto getAuthInfo(){
//        MemberAuthDto auth = new MemberAuthDto((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        return auth;
//    }

    public static RSAPublicKey getRsaPublicKey(String rsaPublicKey) {
        // String publicKeyContent = rsaPublicKey;
        //String publicKeyContent = env.getProperty("jwt.secret.public-key");
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(rsaPublicKey));
        RSAPublicKey publicKey = null;
        try {
            publicKey = (RSAPublicKey) kf.generatePublic(keySpecX509);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getRsaPrivateKey(String rsaPrivateKey) {
        // String privateKeyContent = env.getProperty("jwt.secret.private-key");
        // String privateKeyContent = rsaPrivateKey;
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(rsaPrivateKey));
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(rsaPrivateKey));
        PrivateKey privateKey = null;

        try {
            privateKey = kf.generatePrivate(keySpecPKCS8);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return privateKey;
    }
}
