package com.feijimiao.xianyuassistant.security;

public class AlreadyInitializedException extends RuntimeException {
    public AlreadyInitializedException(String message) {
        super(message);
    }
}
