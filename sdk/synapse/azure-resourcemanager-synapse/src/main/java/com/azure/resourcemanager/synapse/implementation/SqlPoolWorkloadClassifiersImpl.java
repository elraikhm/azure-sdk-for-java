// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.synapse.fluent.SqlPoolWorkloadClassifiersClient;
import com.azure.resourcemanager.synapse.fluent.models.WorkloadClassifierInner;
import com.azure.resourcemanager.synapse.models.SqlPoolWorkloadClassifiers;
import com.azure.resourcemanager.synapse.models.WorkloadClassifier;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class SqlPoolWorkloadClassifiersImpl implements SqlPoolWorkloadClassifiers {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SqlPoolWorkloadClassifiersImpl.class);

    private final SqlPoolWorkloadClassifiersClient innerClient;

    private final com.azure.resourcemanager.synapse.SynapseManager serviceManager;

    public SqlPoolWorkloadClassifiersImpl(
        SqlPoolWorkloadClassifiersClient innerClient, com.azure.resourcemanager.synapse.SynapseManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public WorkloadClassifier get(
        String resourceGroupName,
        String workspaceName,
        String sqlPoolName,
        String workloadGroupName,
        String workloadClassifierName) {
        WorkloadClassifierInner inner =
            this
                .serviceClient()
                .get(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName);
        if (inner != null) {
            return new WorkloadClassifierImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<WorkloadClassifier> getWithResponse(
        String resourceGroupName,
        String workspaceName,
        String sqlPoolName,
        String workloadGroupName,
        String workloadClassifierName,
        Context context) {
        Response<WorkloadClassifierInner> inner =
            this
                .serviceClient()
                .getWithResponse(
                    resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new WorkloadClassifierImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void delete(
        String resourceGroupName,
        String workspaceName,
        String sqlPoolName,
        String workloadGroupName,
        String workloadClassifierName) {
        this
            .serviceClient()
            .delete(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName);
    }

    public void delete(
        String resourceGroupName,
        String workspaceName,
        String sqlPoolName,
        String workloadGroupName,
        String workloadClassifierName,
        Context context) {
        this
            .serviceClient()
            .delete(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, context);
    }

    public PagedIterable<WorkloadClassifier> list(
        String resourceGroupName, String workspaceName, String sqlPoolName, String workloadGroupName) {
        PagedIterable<WorkloadClassifierInner> inner =
            this.serviceClient().list(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName);
        return Utils.mapPage(inner, inner1 -> new WorkloadClassifierImpl(inner1, this.manager()));
    }

    public PagedIterable<WorkloadClassifier> list(
        String resourceGroupName, String workspaceName, String sqlPoolName, String workloadGroupName, Context context) {
        PagedIterable<WorkloadClassifierInner> inner =
            this.serviceClient().list(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, context);
        return Utils.mapPage(inner, inner1 -> new WorkloadClassifierImpl(inner1, this.manager()));
    }

    public WorkloadClassifier getById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = Utils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String sqlPoolName = Utils.getValueFromIdByName(id, "sqlPools");
        if (sqlPoolName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'sqlPools'.", id)));
        }
        String workloadGroupName = Utils.getValueFromIdByName(id, "workloadGroups");
        if (workloadGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'workloadGroups'.", id)));
        }
        String workloadClassifierName = Utils.getValueFromIdByName(id, "workloadClassifiers");
        if (workloadClassifierName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'workloadClassifiers'.", id)));
        }
        return this
            .getWithResponse(
                resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, Context.NONE)
            .getValue();
    }

    public Response<WorkloadClassifier> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = Utils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String sqlPoolName = Utils.getValueFromIdByName(id, "sqlPools");
        if (sqlPoolName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'sqlPools'.", id)));
        }
        String workloadGroupName = Utils.getValueFromIdByName(id, "workloadGroups");
        if (workloadGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'workloadGroups'.", id)));
        }
        String workloadClassifierName = Utils.getValueFromIdByName(id, "workloadClassifiers");
        if (workloadClassifierName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'workloadClassifiers'.", id)));
        }
        return this
            .getWithResponse(
                resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = Utils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String sqlPoolName = Utils.getValueFromIdByName(id, "sqlPools");
        if (sqlPoolName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'sqlPools'.", id)));
        }
        String workloadGroupName = Utils.getValueFromIdByName(id, "workloadGroups");
        if (workloadGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'workloadGroups'.", id)));
        }
        String workloadClassifierName = Utils.getValueFromIdByName(id, "workloadClassifiers");
        if (workloadClassifierName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'workloadClassifiers'.", id)));
        }
        this
            .delete(
                resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = Utils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String sqlPoolName = Utils.getValueFromIdByName(id, "sqlPools");
        if (sqlPoolName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'sqlPools'.", id)));
        }
        String workloadGroupName = Utils.getValueFromIdByName(id, "workloadGroups");
        if (workloadGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'workloadGroups'.", id)));
        }
        String workloadClassifierName = Utils.getValueFromIdByName(id, "workloadClassifiers");
        if (workloadClassifierName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'workloadClassifiers'.", id)));
        }
        this.delete(resourceGroupName, workspaceName, sqlPoolName, workloadGroupName, workloadClassifierName, context);
    }

    private SqlPoolWorkloadClassifiersClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.synapse.SynapseManager manager() {
        return this.serviceManager;
    }

    public WorkloadClassifierImpl define(String name) {
        return new WorkloadClassifierImpl(name, this.manager());
    }
}
