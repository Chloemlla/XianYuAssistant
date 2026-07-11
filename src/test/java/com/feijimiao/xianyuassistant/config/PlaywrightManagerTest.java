package com.feijimiao.xianyuassistant.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaywrightManagerTest {
    @TempDir
    Path tempDirectory;

    @Test
    void fallsBackToUserDirectoryWhenCodeSourceIsUnavailable() {
        assertEquals(tempDirectory.toAbsolutePath().normalize(),
                PlaywrightManager.resolveApplicationDirectory(null, tempDirectory.toString()));
    }

    @Test
    void resolvesParentDirectoryForJarLocation() throws Exception {
        Path jar = Files.createFile(tempDirectory.resolve("application.jar"));
        URL location = jar.toUri().toURL();
        assertEquals(tempDirectory.toAbsolutePath().normalize(),
                PlaywrightManager.resolveApplicationDirectory(location, "."));
    }
}
