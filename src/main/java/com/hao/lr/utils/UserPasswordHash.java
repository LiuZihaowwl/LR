package com.hao.lr.utils;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName UserPasswordHash
 * @Description
 * @Author Administrator
 * @Date 2020/5/30 18:13
 * @Version 1.0
 **/
public class UserPasswordHash {
    // 生成摘要长度 512 位，理论上越长的摘要越难破解。
    private static final int HASH_BIT_SIZE = 512;

    // 迭代次数，按照 在RFC2898文案中推荐 的建议，不少以100次
    private static final int ITERATIONS = 2000;

    // 盐的长度，按照 RFC2898 中的建议，盐的长度不低于64位
    private static final int SALT_BIT_SIZE = 64;

    // 创建密码摘要
    public static String genPasswordHash(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), Base64.decodeBase64(salt), ITERATIONS, HASH_BIT_SIZE);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return Base64.encodeBase64String(hash);
    }

    // 生成随机盐
    public static String genRandomSalt() {
        byte[] salt = new byte[SALT_BIT_SIZE];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }

    // 验证密码
    public static boolean verify(String password, String salt, String passHash)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        String hash = genPasswordHash(password, salt);
        return hash.equals(passHash);
    }

    public static void savePasswordDemo(String passwordHash, String salt) {
        //密码Hash 和 salt 同时存储
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        //原始密码
//        String weakPassword = "1";
//        //生成随机盐
//        String salt = genRandomSalt();
//        //经过加盐后的密码摘要
//        String passwordHash = genPasswordHash(weakPassword, salt);
//        System.out.println(salt);
//        System.out.println(salt.length());
//        System.out.println(passwordHash);
//        System.out.println(passwordHash.length());
//        //同时储存密码hash和盐
//        savePasswordDemo(passwordHash, salt);
//        //验证密码
//        boolean resualt = verify(weakPassword, salt, passwordHash);
//        System.out.println(resualt);
//    }
}
