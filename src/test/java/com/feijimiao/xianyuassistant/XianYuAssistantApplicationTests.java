package com.feijimiao.xianyuassistant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "jwt.secret=ci-test-jwt-secret-with-at-least-32-bytes",
        "security.bootstrap-token=ci-test-bootstrap-token-with-24-chars",
        "ai.enabled=false"
})
class XianYuAssistantApplicationTests {

    @Test
    void contextLoads() {
    }
}
