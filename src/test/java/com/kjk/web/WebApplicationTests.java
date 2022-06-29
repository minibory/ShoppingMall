package com.kjk.web;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jasypt() {
        String url = "jdbc:mariadb://localhost:3306/kjk_db?serverTimezone=UTC&characterEncoding=UTF-8";
        String username = "kjk_db";
        String password = "blue0423";

        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {

        String key = "blue0423";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
