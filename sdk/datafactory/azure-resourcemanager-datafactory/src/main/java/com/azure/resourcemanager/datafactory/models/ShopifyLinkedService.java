// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import java.util.Map;

/** Shopify Service linked service. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("Shopify")
@JsonFlatten
@Fluent
public class ShopifyLinkedService extends LinkedService {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ShopifyLinkedService.class);

    /*
     * The endpoint of the Shopify server. (i.e. mystore.myshopify.com)
     */
    @JsonProperty(value = "typeProperties.host", required = true)
    private Object host;

    /*
     * The API access token that can be used to access Shopify’s data. The
     * token won't expire if it is offline mode.
     */
    @JsonProperty(value = "typeProperties.accessToken")
    private SecretBase accessToken;

    /*
     * Specifies whether the data source endpoints are encrypted using HTTPS.
     * The default value is true.
     */
    @JsonProperty(value = "typeProperties.useEncryptedEndpoints")
    private Object useEncryptedEndpoints;

    /*
     * Specifies whether to require the host name in the server's certificate
     * to match the host name of the server when connecting over SSL. The
     * default value is true.
     */
    @JsonProperty(value = "typeProperties.useHostVerification")
    private Object useHostVerification;

    /*
     * Specifies whether to verify the identity of the server when connecting
     * over SSL. The default value is true.
     */
    @JsonProperty(value = "typeProperties.usePeerVerification")
    private Object usePeerVerification;

    /*
     * The encrypted credential used for authentication. Credentials are
     * encrypted using the integration runtime credential manager. Type: string
     * (or Expression with resultType string).
     */
    @JsonProperty(value = "typeProperties.encryptedCredential")
    private Object encryptedCredential;

    /**
     * Get the host property: The endpoint of the Shopify server. (i.e. mystore.myshopify.com).
     *
     * @return the host value.
     */
    public Object host() {
        return this.host;
    }

    /**
     * Set the host property: The endpoint of the Shopify server. (i.e. mystore.myshopify.com).
     *
     * @param host the host value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withHost(Object host) {
        this.host = host;
        return this;
    }

    /**
     * Get the accessToken property: The API access token that can be used to access Shopify’s data. The token won't
     * expire if it is offline mode.
     *
     * @return the accessToken value.
     */
    public SecretBase accessToken() {
        return this.accessToken;
    }

    /**
     * Set the accessToken property: The API access token that can be used to access Shopify’s data. The token won't
     * expire if it is offline mode.
     *
     * @param accessToken the accessToken value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withAccessToken(SecretBase accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Get the useEncryptedEndpoints property: Specifies whether the data source endpoints are encrypted using HTTPS.
     * The default value is true.
     *
     * @return the useEncryptedEndpoints value.
     */
    public Object useEncryptedEndpoints() {
        return this.useEncryptedEndpoints;
    }

    /**
     * Set the useEncryptedEndpoints property: Specifies whether the data source endpoints are encrypted using HTTPS.
     * The default value is true.
     *
     * @param useEncryptedEndpoints the useEncryptedEndpoints value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withUseEncryptedEndpoints(Object useEncryptedEndpoints) {
        this.useEncryptedEndpoints = useEncryptedEndpoints;
        return this;
    }

    /**
     * Get the useHostVerification property: Specifies whether to require the host name in the server's certificate to
     * match the host name of the server when connecting over SSL. The default value is true.
     *
     * @return the useHostVerification value.
     */
    public Object useHostVerification() {
        return this.useHostVerification;
    }

    /**
     * Set the useHostVerification property: Specifies whether to require the host name in the server's certificate to
     * match the host name of the server when connecting over SSL. The default value is true.
     *
     * @param useHostVerification the useHostVerification value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withUseHostVerification(Object useHostVerification) {
        this.useHostVerification = useHostVerification;
        return this;
    }

    /**
     * Get the usePeerVerification property: Specifies whether to verify the identity of the server when connecting over
     * SSL. The default value is true.
     *
     * @return the usePeerVerification value.
     */
    public Object usePeerVerification() {
        return this.usePeerVerification;
    }

    /**
     * Set the usePeerVerification property: Specifies whether to verify the identity of the server when connecting over
     * SSL. The default value is true.
     *
     * @param usePeerVerification the usePeerVerification value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withUsePeerVerification(Object usePeerVerification) {
        this.usePeerVerification = usePeerVerification;
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @return the encryptedCredential value.
     */
    public Object encryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     *
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the ShopifyLinkedService object itself.
     */
    public ShopifyLinkedService withEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ShopifyLinkedService withConnectVia(IntegrationRuntimeReference connectVia) {
        super.withConnectVia(connectVia);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ShopifyLinkedService withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ShopifyLinkedService withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ShopifyLinkedService withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (host() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property host in model ShopifyLinkedService"));
        }
        if (accessToken() != null) {
            accessToken().validate();
        }
    }
}
