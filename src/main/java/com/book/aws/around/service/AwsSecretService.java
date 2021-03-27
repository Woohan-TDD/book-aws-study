package com.book.aws.around.service;

import java.nio.ByteBuffer;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.services.secretsmanager.model.InvalidParameterException;
import com.amazonaws.services.secretsmanager.model.InvalidRequestException;
import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import com.book.aws.around.dto.SecretResponse;
import com.book.aws.around.exception.SecretValueNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AwsSecretService implements SecretService {
    @Value("${aws.secretsManager.secretName}")
    private String secretName;

    @Value("${aws.secretsManager.region}")
    private String region;

    @Override
    public SecretResponse readSecret() {
        AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
        AWSSecretsManager client = clientBuilder.build();

        String secret = null;
        ByteBuffer binarySecretData;

        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
        GetSecretValueResult getSecretValueResponse = null;
        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (ResourceNotFoundException e) {
            System.out.println("The requested secret " + secretName + " was not found");
        } catch (InvalidRequestException e) {
            System.out.println("The request was invalid due to: " + e.getMessage());
        } catch (InvalidParameterException e) {
            System.out.println("The request had invalid params: " + e.getMessage());
        }

        if (Objects.isNull(getSecretValueResponse)) {
            throw new SecretValueNotFoundException(secretName, region);
        }

        // Decrypted secret using the associated KMS CMK
        // Depending on whether the secret was a string or binary, one of these fields will be populated
        if (Objects.nonNull(getSecretValueResponse.getSecretString())) {
            secret = getSecretValueResponse.getSecretString();
        } else {
            binarySecretData = getSecretValueResponse.getSecretBinary();
        }
        return new SecretResponse(secretName, secret);
    }
}
