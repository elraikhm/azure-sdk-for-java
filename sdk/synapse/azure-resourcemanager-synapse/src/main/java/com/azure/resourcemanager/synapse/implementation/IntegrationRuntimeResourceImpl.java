// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.synapse.fluent.models.IntegrationRuntimeResourceInner;
import com.azure.resourcemanager.synapse.models.IntegrationRuntime;
import com.azure.resourcemanager.synapse.models.IntegrationRuntimeAutoUpdate;
import com.azure.resourcemanager.synapse.models.IntegrationRuntimeResource;
import com.azure.resourcemanager.synapse.models.IntegrationRuntimeStatusResponse;
import com.azure.resourcemanager.synapse.models.UpdateIntegrationRuntimeRequest;

public final class IntegrationRuntimeResourceImpl
    implements IntegrationRuntimeResource, IntegrationRuntimeResource.Definition, IntegrationRuntimeResource.Update {
    private IntegrationRuntimeResourceInner innerObject;

    private final com.azure.resourcemanager.synapse.SynapseManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String etag() {
        return this.innerModel().etag();
    }

    public IntegrationRuntime properties() {
        return this.innerModel().properties();
    }

    public IntegrationRuntimeResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.synapse.SynapseManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String workspaceName;

    private String integrationRuntimeName;

    private String createIfMatch;

    private UpdateIntegrationRuntimeRequest updateUpdateIntegrationRuntimeRequest;

    public IntegrationRuntimeResourceImpl withExistingWorkspace(String resourceGroupName, String workspaceName) {
        this.resourceGroupName = resourceGroupName;
        this.workspaceName = workspaceName;
        return this;
    }

    public IntegrationRuntimeResource create() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .create(
                    resourceGroupName,
                    workspaceName,
                    integrationRuntimeName,
                    this.innerModel(),
                    createIfMatch,
                    Context.NONE);
        return this;
    }

    public IntegrationRuntimeResource create(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .create(
                    resourceGroupName,
                    workspaceName,
                    integrationRuntimeName,
                    this.innerModel(),
                    createIfMatch,
                    context);
        return this;
    }

    IntegrationRuntimeResourceImpl(String name, com.azure.resourcemanager.synapse.SynapseManager serviceManager) {
        this.innerObject = new IntegrationRuntimeResourceInner();
        this.serviceManager = serviceManager;
        this.integrationRuntimeName = name;
        this.createIfMatch = null;
    }

    public IntegrationRuntimeResourceImpl update() {
        this.updateUpdateIntegrationRuntimeRequest = new UpdateIntegrationRuntimeRequest();
        return this;
    }

    public IntegrationRuntimeResource apply() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .updateWithResponse(
                    resourceGroupName,
                    workspaceName,
                    integrationRuntimeName,
                    updateUpdateIntegrationRuntimeRequest,
                    Context.NONE)
                .getValue();
        return this;
    }

    public IntegrationRuntimeResource apply(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .updateWithResponse(
                    resourceGroupName,
                    workspaceName,
                    integrationRuntimeName,
                    updateUpdateIntegrationRuntimeRequest,
                    context)
                .getValue();
        return this;
    }

    IntegrationRuntimeResourceImpl(
        IntegrationRuntimeResourceInner innerObject, com.azure.resourcemanager.synapse.SynapseManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = Utils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.workspaceName = Utils.getValueFromIdByName(innerObject.id(), "workspaces");
        this.integrationRuntimeName = Utils.getValueFromIdByName(innerObject.id(), "integrationRuntimes");
    }

    public IntegrationRuntimeResource refresh() {
        String localIfNoneMatch = null;
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .getWithResponse(
                    resourceGroupName, workspaceName, integrationRuntimeName, localIfNoneMatch, Context.NONE)
                .getValue();
        return this;
    }

    public IntegrationRuntimeResource refresh(Context context) {
        String localIfNoneMatch = null;
        this.innerObject =
            serviceManager
                .serviceClient()
                .getIntegrationRuntimes()
                .getWithResponse(resourceGroupName, workspaceName, integrationRuntimeName, localIfNoneMatch, context)
                .getValue();
        return this;
    }

    public void upgrade() {
        serviceManager.integrationRuntimes().upgrade(resourceGroupName, workspaceName, integrationRuntimeName);
    }

    public Response<Void> upgradeWithResponse(Context context) {
        return serviceManager
            .integrationRuntimes()
            .upgradeWithResponse(resourceGroupName, workspaceName, integrationRuntimeName, context);
    }

    public IntegrationRuntimeStatusResponse start() {
        return serviceManager.integrationRuntimes().start(resourceGroupName, workspaceName, integrationRuntimeName);
    }

    public IntegrationRuntimeStatusResponse start(Context context) {
        return serviceManager
            .integrationRuntimes()
            .start(resourceGroupName, workspaceName, integrationRuntimeName, context);
    }

    public void stop() {
        serviceManager.integrationRuntimes().stop(resourceGroupName, workspaceName, integrationRuntimeName);
    }

    public void stop(Context context) {
        serviceManager.integrationRuntimes().stop(resourceGroupName, workspaceName, integrationRuntimeName, context);
    }

    public void enableInteractiveQuery() {
        serviceManager
            .integrationRuntimes()
            .enableInteractiveQuery(resourceGroupName, workspaceName, integrationRuntimeName);
    }

    public void enableInteractiveQuery(Context context) {
        serviceManager
            .integrationRuntimes()
            .enableInteractiveQuery(resourceGroupName, workspaceName, integrationRuntimeName, context);
    }

    public void disableInteractiveQuery() {
        serviceManager
            .integrationRuntimes()
            .disableInteractiveQuery(resourceGroupName, workspaceName, integrationRuntimeName);
    }

    public void disableInteractiveQuery(Context context) {
        serviceManager
            .integrationRuntimes()
            .disableInteractiveQuery(resourceGroupName, workspaceName, integrationRuntimeName, context);
    }

    public IntegrationRuntimeResourceImpl withProperties(IntegrationRuntime properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public IntegrationRuntimeResourceImpl withIfMatch(String ifMatch) {
        this.createIfMatch = ifMatch;
        return this;
    }

    public IntegrationRuntimeResourceImpl withAutoUpdate(IntegrationRuntimeAutoUpdate autoUpdate) {
        this.updateUpdateIntegrationRuntimeRequest.withAutoUpdate(autoUpdate);
        return this;
    }

    public IntegrationRuntimeResourceImpl withUpdateDelayOffset(String updateDelayOffset) {
        this.updateUpdateIntegrationRuntimeRequest.withUpdateDelayOffset(updateDelayOffset);
        return this;
    }
}
