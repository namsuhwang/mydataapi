package com.abcc.mydataapi.common;

import org.springframework.beans.factory.annotation.Value;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class CommUtil {

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

    public static boolean isListNullEmpty(List<?> list){
        boolean result;
        if(list == null || list.size() == 0){
            result = true;
        }else{
            result = false;
        }
        return result;
    }


    // 현재 일자를 String 8 자리로 반환
    public static String getCurrentDate8(){
        Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다.
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMdd");
        return fourteen_format.format(date_now);
    }

    // 현재 시간을 String 14 자리로 반환
    public static String getCurrentDateTime14(){
        Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다. 년월일시분초 14자리 포멧
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
        return fourteen_format.format(date_now);
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

    /*
        scope로 업권유형 조회
     */
    public static String getIdstTypeByScope(String scope){
        if(isNullEmpty(scope)){
            return scope;
        }

        String idstType = null;
        switch(scope.split(".")[0].toUpperCase()){
            case "BANK" : idstType = "BANK"; break;
            case "CARD" : idstType = "CARD"; break;
            case "INSU" : idstType = "INSU"; break;
            case "INVEST" : idstType = "INVT"; break;
            case "EFIN" : idstType = "ELEC"; break;
            case "GINSU" : idstType = "GURT"; break;
            case "TELECOM" : idstType = "TELE"; break;
            case "P2P" : idstType = "P2P"; break;
            case "BOND" : idstType = "BOND"; break;
            case "CAPTITAL" : idstType = "ITFN"; break;
            default: idstType = null; break;
        }

        return idstType;
    }
}
