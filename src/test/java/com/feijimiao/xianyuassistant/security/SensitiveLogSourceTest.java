package com.feijimiao.xianyuassistant.security;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SensitiveLogSourceTest {
    @Test
    void sourceDoesNotContainKnownPlaintextLoggingPatterns() throws IOException {
        Path root = Path.of("src/main/java");
        String source;
        try (var files = Files.walk(root)) {
            source = files.filter(path -> path.toString().endsWith(".java"))
                    .map(this::read)
                    .reduce("", String::concat);
        }
        assertFalse(source.contains("注册消息内容: {}"));
        assertFalse(source.contains("accessToken前50字符"));
        assertFalse(source.contains("prompt={}, goodsId"));
        assertFalse(source.contains("hasLogin响应: {}"));
        assertFalse(source.contains("完整响应内容: {}"));
    }

    private String read(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
