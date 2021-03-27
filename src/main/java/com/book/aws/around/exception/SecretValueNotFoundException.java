package com.book.aws.around.exception;

public class SecretValueNotFoundException extends RuntimeException {
    public SecretValueNotFoundException(final String secretName, final String region) {
        super("Secret value not found: secretName: " + secretName + ", region: " + region);
    }
}
