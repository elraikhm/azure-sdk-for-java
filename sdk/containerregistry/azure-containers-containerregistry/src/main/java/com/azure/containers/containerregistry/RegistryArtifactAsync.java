// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.containers.containerregistry;

import com.azure.containers.containerregistry.implementation.ContainerRegistriesImpl;
import com.azure.containers.containerregistry.implementation.ContainerRegistryImpl;
import com.azure.containers.containerregistry.implementation.ContainerRegistryImplBuilder;
import com.azure.containers.containerregistry.implementation.models.TagAttributesBase;
import com.azure.containers.containerregistry.models.ArtifactManifestProperties;
import com.azure.containers.containerregistry.models.ArtifactTagProperties;
import com.azure.containers.containerregistry.models.ContainerRegistryServiceVersion;
import com.azure.containers.containerregistry.models.ContentProperties;
import com.azure.containers.containerregistry.models.TagOrderBy;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.azure.core.util.FluxUtil.monoError;
import static com.azure.core.util.FluxUtil.withContext;

/**
 * This class provides a client that contains all the operations for repositories in Azure Container Registry.
 * Operations allowed by the client are listing, retrieving, deleting, setting writeable properties.
 * These operations are supported on the repository and the respective tags and manifests in it.
 *
 * <p><strong>Instantiating an asynchronous Container Repository Client</strong></p>
 *
 * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.instantiation}
 *
 * <p>View {@link ContainerRegistryClientBuilder this} for additional ways to construct the client.</p>
 *
 * @see ContainerRegistryClientBuilder
 */
public final class RegistryArtifactAsync {
    private final ContainerRegistriesImpl serviceClient;
    private final String repositoryName;
    private final String tagOrDigest;
    private final String endpoint;
    private final String apiVersion;
    private String digest;

    private final ClientLogger logger = new ClientLogger(RegistryArtifactAsync.class);

    /**
     * Creates a ContainerRepositoryAsyncClient that sends requests to the given repository in the container registry service at {@code endpoint}.
     * Each service call goes through the {@code pipeline}.
     * @param repositoryName The name of the repository on which the service operations are performed.
     * @param tagOrDigest The tag or digest associated with the given artifact.
     * @param endpoint The URL string for the Azure Container Registry service.
     * @param httpPipeline HttpPipeline that the HTTP requests and responses flow through.
     * @param version {@link ContainerRegistryServiceVersion} of the service to be used when making requests.
     */
    RegistryArtifactAsync(String repositoryName, String tagOrDigest, HttpPipeline httpPipeline, String endpoint, String version) {
        if (repositoryName == null) {
            throw logger.logExceptionAsError(new NullPointerException("'repositoryName' can't be null"));
        }

        if (tagOrDigest == null) {
            throw logger.logExceptionAsError(new NullPointerException("'tagOrDigest' can't be null"));
        }

        ContainerRegistryImpl registryImpl = new ContainerRegistryImplBuilder()
            .pipeline(httpPipeline)
            .url(endpoint).buildClient();

        this.endpoint = endpoint;
        this.repositoryName = repositoryName;
        this.tagOrDigest = tagOrDigest;
        this.serviceClient = registryImpl.getContainerRegistries();
        this.apiVersion = version;
    }

    /**
     * Gets the Azure Container Registry service endpoint for the current instance.
     * @return The service endpoint for the current instance.
     */
    public String getRegistryEndpoint() {
        return this.endpoint;
    }

    /**
     * Gets the repository name for the current instance.
     * Gets the repository name for the current instance.
     * @return Name of the repository for the current instance.
     * */
    public String getRepositoryName() {
        return this.repositoryName;
    }

    /**
     * Gets the tag or digest for the current instance.
     * @return Tag or digest information for the current instance.
     * */
    public String getTagOrDigest() {
        return this.tagOrDigest;
    }


    private Mono<String> getDigest() {
        if (digest != null) {
            return Mono.just(digest);
        }

        Mono<String> getTagMono = tagOrDigest.contains(":")
            ? Mono.just(tagOrDigest)
            : this.getTagProperties(tagOrDigest).map(a -> a.getDigest());

        return getTagMono.flatMap(res -> {
            this.digest = res;
            return Mono.just(res);
        });
    }

    /**
     * Deletes the registry artifact with the matching digest in the given {@link #getRepositoryName() respository.}
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Delete the registry artifact.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.deleteWithResponse}
     *
     * @return A REST response with completion signal.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws NullPointerException thrown if digest is null.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteWithResponse() {
        return withContext(context -> this.deleteWithResponse(context));
    }

    Mono<Response<Void>> deleteWithResponse(Context context) {
        try {
            return this.getDigest()
                .flatMap(res -> this.serviceClient.deleteManifestWithResponseAsync(repositoryName, res, context))
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Deletes the registry artifact with the matching digest in the given {@link #getRepositoryName() respository.}
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Delete the registry artifact.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.delete}
     *
     * @return the completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws NullPointerException thrown if digest is null.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> delete() {
        return this.deleteWithResponse().flatMap(FluxUtil::toMono);
    }

    /**
     * Deletes the tag with the matching tag name for the given {@link #getRepositoryName() repository}.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Delete the tag for the given repository.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.deleteTagWithResponse}
     *
     * @param tag The name of the tag that uniquely identifies the tag that needs to be deleted.
     * @return A REST response with completion signal.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws NullPointerException thrown if tag is null.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTagWithResponse(String tag) {
        return withContext(context -> this.deleteTagWithResponse(tag, context));
    }

    Mono<Response<Void>> deleteTagWithResponse(String tag, Context context) {
        try {
            if (tag == null) {
                return monoError(logger, new NullPointerException("'tag' cannot be null"));
            }
            return this.serviceClient.deleteTagWithResponseAsync(repositoryName, tag, context)
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Deletes the tag with the matching tag name for the given {@link #getRepositoryName() repository}.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Delete the tag for the given repository.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.deleteTag}
     *
     * @param tag The name of the tag that uniquely identifies the tag that needs to be deleted.
     * @return The completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws NullPointerException thrown if tag is null.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTag(String tag) {
        return this.deleteTagWithResponse(tag).flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the {@link ArtifactManifestProperties properties} associated with an artifact in given {@link #getRepositoryName() repository}.
     *
     * <p>This method can take in both a digest as well as a tag.<br>
     * In case a tag is provided it calls the service to get the digest associated with the given tag.</p>
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Get the properties for the given repository.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.getManifestPropertiesWithResponse}
     *
     * @return A REST response containing {@link ArtifactManifestProperties properties} associated with the given {@code tagOrDigest}.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ArtifactManifestProperties>> getManifestPropertiesWithResponse() {
        return withContext(context -> this.getManifestPropertiesWithResponse(context));
    }

    Mono<Response<ArtifactManifestProperties>> getManifestPropertiesWithResponse(Context context) {
        try {
            return this.getDigest()
                .flatMap(res -> this.serviceClient.getManifestPropertiesWithResponseAsync(repositoryName, res))
                .map(res -> Utils.mapResponse(res, this::mapProperties))
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * We want both the list artifacts call and the get artifact call share the same model.
     * which the swagger does not.
     * As a result we need to ensure that the we can map one implementation to the other.
     * Also, we want to customize the type of one of the fields to ensure minimum models are exposed.
     * @param propsImpl implementation model for this type.
     * @return public model for propsImpl
     */
    ArtifactManifestProperties mapProperties(com.azure.containers.containerregistry.implementation.models.ArtifactManifestProperties propsImpl) {
        return Utils.mapProperties(propsImpl, repositoryName);
    }

    /**
     * Gets the {@link ArtifactManifestProperties properties} associated with an artifact in given {@link #getRepositoryName() repository}.
     *
     * <p>This method can take in both a digest as well as a tag.<br>
     * In case a tag is provided it calls the service to get the digest associated with the given tag.</p>
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Get the properties for the given repository.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.getManifestProperties}.
     *
     * @return The {@link ArtifactManifestProperties properties} associated with the given {@code tagOrDigest}.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ArtifactManifestProperties> getManifestProperties() {
        return this.getManifestPropertiesWithResponse().flatMap(FluxUtil::toMono);
    }

    /**
     * Gets the tag properties associated with a given tag in the {@link #getRepositoryName() repository}.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Retrieve the properties associated with the given tag.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.getTagPropertiesWithResponse}.
     *
     * @param tag name of the tag that uniquely identifies a given tag.
     * @return A REST response with the {@link ArtifactTagProperties properties} associated with the given tag.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ArtifactTagProperties>> getTagPropertiesWithResponse(String tag) {
        return withContext(context -> getTagPropertiesWithResponse(tag, context));
    }

    Mono<Response<ArtifactTagProperties>> getTagPropertiesWithResponse(String tag, Context context) {
        try {
            if (tag == null) {
                return monoError(logger, new NullPointerException("'tag' cannot be null."));
            }

            return this.serviceClient.getTagPropertiesWithResponseAsync(repositoryName, tag, context)
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Gets the tag properties associated with a given tag in the {@link #getRepositoryName() repository}.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Retrieve the properties associated with the given tag.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.getTagProperties}.
     *
     * @param tag name of the tag that uniquely identifies a given tag.
     * @return The {@link ArtifactTagProperties properties} associated with the given tag.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ArtifactTagProperties> getTagProperties(String tag) {
        return this.getTagPropertiesWithResponse(tag).flatMap(FluxUtil::toMono);
    }

    /**
     * Fetches all the tags associated with the given {@link #getRepositoryName() repository}.
     *
     * <p> If you would like to specify the order in which the tags are returned please
     * use the overload that takes in the options parameter {@link #listTags(TagOrderBy)}  listTags}
     * No assumptions on the order can be made if no options are provided to the service.
     * </p>
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Retrieve all the tags associated with the given repository from the most recently updated to the last.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.listTagsWithOptions}.
     *
     * @return {@link PagedFlux} of the artifacts for the given repository in the order specified by the options.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<ArtifactTagProperties> listTags() {
        return listTags(TagOrderBy.NONE);
    }

    /**
     * Fetches all the tags associated with the given {@link #getRepositoryName() repository}.
     *
     * <p> The method supports options to select the order in which the tags are returned by the service.
     * Currently the service supports an ascending or descending order based on the last updated time of the tag.
     * No assumptions on the order can be made if no options are provided to the service.
     * </p>
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Retrieve all the tags associated with the given repository from the most recently updated to the last.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.listTagsWithOptions}.
     *
     * @param orderBy The order in which the tags should be returned by the service.
     * @return {@link PagedFlux} of the artifacts for the given repository in the order specified by the options.
     * @throws ClientAuthenticationException thrown if the client does not have access to the repository.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<ArtifactTagProperties> listTags(TagOrderBy orderBy) {
        return new PagedFlux<>(
            (pageSize) -> withContext(context -> listTagsSinglePageAsync(pageSize, orderBy, context)),
            (token, pageSize) -> withContext(context -> listTagsNextSinglePageAsync(token, context)));
    }

    PagedFlux<ArtifactTagProperties> listTags(TagOrderBy orderBy, Context context) {
        return new PagedFlux<>(
            (pageSize) -> listTagsSinglePageAsync(pageSize, orderBy, context),
            (token, pageSize) -> listTagsNextSinglePageAsync(token, context));
    }

    Mono<PagedResponse<ArtifactTagProperties>> listTagsSinglePageAsync(Integer pageSize, TagOrderBy orderBy, Context context) {
        try {
            if (pageSize != null && pageSize < 0) {
                return monoError(logger, new IllegalArgumentException("'pageSize' cannot be negative."));
            }

            final String orderByString = orderBy.equals(TagOrderBy.NONE) ? null : orderBy.toString();

            return this.getDigest()
                .flatMap(res -> this.serviceClient.getTagsSinglePageAsync(repositoryName, null, pageSize, orderByString, res, context))
                .map(res -> Utils.getPagedResponseWithContinuationToken(res, this::getTagProperties))
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException e) {
            return monoError(logger, e);
        }
    }

    private List<ArtifactTagProperties> getTagProperties(List<TagAttributesBase> baseValues) {
        Objects.requireNonNull(baseValues);

        return baseValues.stream().map(value -> new ArtifactTagProperties(
            value.getName(),
            repositoryName,
            value.getDigest(),
            value.getWriteableProperties(),
            value.getCreatedOn(),
            value.getLastUpdatedOn()
        )).collect(Collectors.toList());
    }

    Mono<PagedResponse<ArtifactTagProperties>> listTagsNextSinglePageAsync(String nextLink, Context context) {
        try {
            return this.serviceClient.getTagsNextSinglePageAsync(nextLink, context)
                .map(res -> Utils.getPagedResponseWithContinuationToken(res, this::getTagProperties));
        } catch (RuntimeException e) {
            return monoError(logger, e);
        }
    }

    /**
     * Update the writeable properties {@link ContentProperties} of the tag with the given name {@code tag}..
     * These properties set whether the given tag can be updated, deleted and retrieved.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Update the writeable properties of a given tag.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.updateTagPropertiesWithResponse}.
     *
     * @param tag Name of the tag that uniquely identifies it.
     * @param value {@link ContentProperties value} to be set.
     * @return A REST response for completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ArtifactTagProperties>> updateTagPropertiesWithResponse(
            String tag, ContentProperties value) {
        return withContext(context -> this.updateTagPropertiesWithResponse(tag, value, context));
    }

    Mono<Response<ArtifactTagProperties>> updateTagPropertiesWithResponse(
        String tag, ContentProperties value, Context context) {
        try {
            if (tag == null) {
                return monoError(logger, new NullPointerException("'tag' cannot be null."));
            }

            if (value == null) {
                return monoError(logger, new NullPointerException("'value' cannot be null."));
            }

            return this.serviceClient.updateTagAttributesWithResponseAsync(repositoryName, tag, value, context)
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException e) {
            return monoError(logger, e);
        }
    }

    /**
     * Update the writeable properties {@link ContentProperties} of the tag with the given name {@code tag}.
     * These properties set whether the given tag can be updated, deleted and retrieved.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Update the writeable properties of a given tag.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.updateTagPropertiesWithResponse}.
     *
     * @param tag Name of the tag that uniquely identifies it.
     * @param value {@link ContentProperties value} to be set.
     * @return The completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to repository.
     * @throws ResourceNotFoundException thrown if the given tag was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ArtifactTagProperties> updateTagProperties(String tag, ContentProperties value) {
        return this.updateTagPropertiesWithResponse(tag, value).flatMap(FluxUtil::toMono);
    }

    /**
     * Update the writeable properties {@link ContentProperties} of the artifact with the given {@code digest}.
     * These properties set whether the given manifest can be updated, deleted and retrieved.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Update the writeable properties of a given manifest.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.updateManifestPropertiesWithResponse}.
     *
     * @param value {@link ContentProperties value} to be set.
     * @return A REST response for the completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<ArtifactManifestProperties>> updateManifestPropertiesWithResponse(ContentProperties value) {
        return withContext(context -> this.updateManifestPropertiesWithResponse(value, context));
    }

    Mono<Response<ArtifactManifestProperties>> updateManifestPropertiesWithResponse(ContentProperties value, Context context) {
        try {
            if (value == null) {
                return monoError(logger, new NullPointerException("'value' cannot be null."));
            }

            return getDigest()
                .flatMap(res -> this.serviceClient.updateManifestPropertiesWithResponseAsync(repositoryName, res, value, context))
                .map(res -> Utils.mapResponse(res, this::mapProperties))
                .onErrorMap(Utils::mapException);
        } catch (RuntimeException e) {
            return monoError(logger, e);
        }
    }

    /**
     * Update the writeable properties {@link ContentProperties} of the artifact with the given {@code digest}.
     * These properties set whether the given manifest can be updated, deleted and retrieved.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * <p>Update the writeable properties of a given manifest.</p>
     *
     * {@codesnippet com.azure.containers.containerregistry.async.registryartifact.updateManifestProperties}.
     *
     * @param value {@link ContentProperties value} to be set.
     * @return The completion.
     * @throws ClientAuthenticationException thrown if the client does not have access to repository.
     * @throws ResourceNotFoundException thrown if the given digest was not found.
     * @throws HttpResponseException thrown if any other unexpected exception is returned by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<ArtifactManifestProperties> updateManifestProperties(ContentProperties value) {
        return this.updateManifestPropertiesWithResponse(value).flatMap(FluxUtil::toMono);
    }
}
