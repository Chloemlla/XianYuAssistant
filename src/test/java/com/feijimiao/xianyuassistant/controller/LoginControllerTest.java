package com.feijimiao.xianyuassistant.controller;

import com.feijimiao.xianyuassistant.controller.dto.RegisterReqDTO;
import com.feijimiao.xianyuassistant.security.AlreadyInitializedException;
import com.feijimiao.xianyuassistant.security.BootstrapAuthorizationException;
import com.feijimiao.xianyuassistant.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginControllerTest {
    @Test
    void missingBootstrapAuthorizationReturns403() {
        AuthService authService = mock(AuthService.class);
        when(authService.register(any())).thenThrow(new BootstrapAuthorizationException("bootstrap required"));
        LoginController controller = new LoginController();
        ReflectionTestUtils.setField(controller, "authService", authService);
        assertEquals(403, controller.register(validRequest(), mock(HttpServletRequest.class)).getCode());
    }

    @Test
    void registrationAfterInitializationReturns409() {
        AuthService authService = mock(AuthService.class);
        when(authService.register(any())).thenThrow(new AlreadyInitializedException("initialized"));
        LoginController controller = new LoginController();
        ReflectionTestUtils.setField(controller, "authService", authService);
        assertEquals(409, controller.register(validRequest(), mock(HttpServletRequest.class)).getCode());
    }

    private RegisterReqDTO validRequest() {
        RegisterReqDTO request = new RegisterReqDTO();
        request.setUsername("admin");
        request.setPassword("secret123");
        request.setConfirmPassword("secret123");
        request.setBootstrapToken("bootstrap-token");
        return request;
    }
}
