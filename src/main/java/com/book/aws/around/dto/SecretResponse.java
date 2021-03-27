package com.book.aws.around.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SecretResponse {
    private final String secretName;
    private final String secretValue;
}
