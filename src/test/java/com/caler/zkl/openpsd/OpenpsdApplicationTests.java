package com.caler.zkl.openpsd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class OpenpsdApplicationTests {

    @Test
    void contextLoads() {
        String bc = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(bc);
    }

}
