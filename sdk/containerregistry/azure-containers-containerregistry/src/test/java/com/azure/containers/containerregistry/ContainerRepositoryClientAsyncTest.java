// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.containers.containerregistry;

import com.azure.containers.containerregistry.models.RegistryArtifactProperties;
import com.azure.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.azure.containers.containerregistry.TestUtils.DIGEST_UNKNOWN;
import static com.azure.containers.containerregistry.TestUtils.HELLO_WORLD_REPOSITORY_NAME;
import static com.azure.containers.containerregistry.TestUtils.LATEST_TAG_NAME;
import static com.azure.containers.containerregistry.TestUtils.TAG_UNKNOWN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContainerRepositoryClientAsyncTest extends ContainerRegistryClientsTestBase {
    private String recordFileName;
    private static final String PARENT_FILENAME = "ContainerRepositoryClientAsyncIntegrationTests";

    private ContainerRepositoryAsyncClient getContainerRepositoryAsyncClient() {
        return getContainerRepositoryBuilder(HELLO_WORLD_REPOSITORY_NAME, new LocalHttpClient(recordFileName)).buildAsyncClient();
    }

    private ContainerRepositoryAsyncClient getUnknownContainerRepositoryAsyncClient() {
        return getContainerRepositoryBuilder("Unknown", new LocalHttpClient(recordFileName)).buildAsyncClient();
    }

    @Test
    public void getRepositoryProperties() {
        recordFileName = PARENT_FILENAME + "." + "getRepositoryPropertiesWithResponse[1].json";
        ContainerRepositoryAsyncClient client = getContainerRepositoryAsyncClient();

        StepVerifier.create(client.getProperties())
            .assertNext(res -> {
                assertNotNull(res);
                assertEquals(HELLO_WORLD_REPOSITORY_NAME, res.getName());
            })
            .verifyComplete();
    }

    @Test
    public void getUnknownRepositoryProperties() {
        recordFileName = PARENT_FILENAME + "." + "getUnknownRepositoryPropertiesWithResponse[1].json";
        ContainerRepositoryAsyncClient client = getUnknownContainerRepositoryAsyncClient();

        StepVerifier.create(client.getProperties())
            .expectError(ResourceNotFoundException.class)
            .verify();
    }

    @Test
    public void getMultiArchitectureImageProperties() {
        recordFileName = PARENT_FILENAME + "." + "getMultiArchitectureImagePropertiesWithResponse[1].json";
        ContainerRepositoryAsyncClient client = getContainerRepositoryAsyncClient();

        Mono<RegistryArtifactProperties> safeTestRegistyArtifacts = client.getRegistryArtifactProperties(LATEST_TAG_NAME)
            .flatMap(res -> {
                validateArtifactProperties(res, true, false);
                return Mono.just(res);
            }).flatMap(res -> client.getRegistryArtifactProperties(res.getDigest()));

        StepVerifier.create(safeTestRegistyArtifacts)
            .assertNext(res -> validateArtifactProperties(res, true, false))
            .verifyComplete();
    }

    @Test
    public void getRegistryArtifactPropertiesThrows() {
        recordFileName = PARENT_FILENAME + "." + "getMultiArchitectureImagePropertiesWithResponseThrows[1].json";
        ContainerRepositoryAsyncClient client = getContainerRepositoryAsyncClient();

        StepVerifier.create(client.getRegistryArtifactPropertiesWithResponse(DIGEST_UNKNOWN))
            .expectError(ResourceNotFoundException.class)
            .verify();
    }

    @Test
    public void getTagProperties() {
        recordFileName = PARENT_FILENAME + "." + "getTagPropertiesWithResponse[1].json";
        ContainerRepositoryAsyncClient client = getContainerRepositoryAsyncClient();

        StepVerifier.create(client.getTagProperties(LATEST_TAG_NAME))
            .assertNext(res -> validateTagProperties(res, LATEST_TAG_NAME))
            .verifyComplete();
    }

    @Test
    public void getTagPropertiesThrows() {
        recordFileName = PARENT_FILENAME + "." + "getTagPropertiesWithResponseThrows[1].json";
        ContainerRepositoryAsyncClient client = getContainerRepositoryAsyncClient();

        StepVerifier.create(client.getTagPropertiesWithResponse(TAG_UNKNOWN))
            .expectError(ResourceNotFoundException.class)
            .verify();
    }
}
