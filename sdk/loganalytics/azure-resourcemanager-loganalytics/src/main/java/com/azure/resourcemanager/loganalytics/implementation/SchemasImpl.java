// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.loganalytics.fluent.SchemasClient;
import com.azure.resourcemanager.loganalytics.fluent.models.SearchGetSchemaResponseInner;
import com.azure.resourcemanager.loganalytics.models.Schemas;
import com.azure.resourcemanager.loganalytics.models.SearchGetSchemaResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class SchemasImpl implements Schemas {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SchemasImpl.class);

    private final SchemasClient innerClient;

    private final com.azure.resourcemanager.loganalytics.LogAnalyticsManager serviceManager;

    public SchemasImpl(
        SchemasClient innerClient, com.azure.resourcemanager.loganalytics.LogAnalyticsManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public SearchGetSchemaResponse get(String resourceGroupName, String workspaceName) {
        SearchGetSchemaResponseInner inner = this.serviceClient().get(resourceGroupName, workspaceName);
        if (inner != null) {
            return new SearchGetSchemaResponseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<SearchGetSchemaResponse> getWithResponse(
        String resourceGroupName, String workspaceName, Context context) {
        Response<SearchGetSchemaResponseInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, workspaceName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new SearchGetSchemaResponseImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private SchemasClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.loganalytics.LogAnalyticsManager manager() {
        return this.serviceManager;
    }
}
