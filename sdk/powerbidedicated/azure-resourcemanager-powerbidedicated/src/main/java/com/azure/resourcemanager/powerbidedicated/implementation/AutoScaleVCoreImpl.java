// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.powerbidedicated.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.powerbidedicated.fluent.models.AutoScaleVCoreInner;
import com.azure.resourcemanager.powerbidedicated.models.AutoScaleVCore;
import com.azure.resourcemanager.powerbidedicated.models.AutoScaleVCoreSku;
import com.azure.resourcemanager.powerbidedicated.models.AutoScaleVCoreUpdateParameters;
import com.azure.resourcemanager.powerbidedicated.models.VCoreProvisioningState;
import java.util.Collections;
import java.util.Map;

public final class AutoScaleVCoreImpl implements AutoScaleVCore, AutoScaleVCore.Definition, AutoScaleVCore.Update {
    private AutoScaleVCoreInner innerObject;

    private final com.azure.resourcemanager.powerbidedicated.PowerBIDedicatedManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public AutoScaleVCoreSku sku() {
        return this.innerModel().sku();
    }

    public Integer capacityLimit() {
        return this.innerModel().capacityLimit();
    }

    public String capacityObjectId() {
        return this.innerModel().capacityObjectId();
    }

    public VCoreProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public AutoScaleVCoreInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.powerbidedicated.PowerBIDedicatedManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String vcoreName;

    private AutoScaleVCoreUpdateParameters updateVCoreUpdateParameters;

    public AutoScaleVCoreImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public AutoScaleVCore create() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .createWithResponse(resourceGroupName, vcoreName, this.innerModel(), Context.NONE)
                .getValue();
        return this;
    }

    public AutoScaleVCore create(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .createWithResponse(resourceGroupName, vcoreName, this.innerModel(), context)
                .getValue();
        return this;
    }

    AutoScaleVCoreImpl(String name, com.azure.resourcemanager.powerbidedicated.PowerBIDedicatedManager serviceManager) {
        this.innerObject = new AutoScaleVCoreInner();
        this.serviceManager = serviceManager;
        this.vcoreName = name;
    }

    public AutoScaleVCoreImpl update() {
        this.updateVCoreUpdateParameters = new AutoScaleVCoreUpdateParameters();
        return this;
    }

    public AutoScaleVCore apply() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .updateWithResponse(resourceGroupName, vcoreName, updateVCoreUpdateParameters, Context.NONE)
                .getValue();
        return this;
    }

    public AutoScaleVCore apply(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .updateWithResponse(resourceGroupName, vcoreName, updateVCoreUpdateParameters, context)
                .getValue();
        return this;
    }

    AutoScaleVCoreImpl(
        AutoScaleVCoreInner innerObject,
        com.azure.resourcemanager.powerbidedicated.PowerBIDedicatedManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = Utils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.vcoreName = Utils.getValueFromIdByName(innerObject.id(), "autoScaleVCores");
    }

    public AutoScaleVCore refresh() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .getByResourceGroupWithResponse(resourceGroupName, vcoreName, Context.NONE)
                .getValue();
        return this;
    }

    public AutoScaleVCore refresh(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getAutoScaleVCores()
                .getByResourceGroupWithResponse(resourceGroupName, vcoreName, context)
                .getValue();
        return this;
    }

    public AutoScaleVCoreImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public AutoScaleVCoreImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public AutoScaleVCoreImpl withSku(AutoScaleVCoreSku sku) {
        if (isInCreateMode()) {
            this.innerModel().withSku(sku);
            return this;
        } else {
            this.updateVCoreUpdateParameters.withSku(sku);
            return this;
        }
    }

    public AutoScaleVCoreImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateVCoreUpdateParameters.withTags(tags);
            return this;
        }
    }

    public AutoScaleVCoreImpl withCapacityLimit(Integer capacityLimit) {
        if (isInCreateMode()) {
            this.innerModel().withCapacityLimit(capacityLimit);
            return this;
        } else {
            this.updateVCoreUpdateParameters.withCapacityLimit(capacityLimit);
            return this;
        }
    }

    public AutoScaleVCoreImpl withCapacityObjectId(String capacityObjectId) {
        this.innerModel().withCapacityObjectId(capacityObjectId);
        return this;
    }

    public AutoScaleVCoreImpl withSystemData(SystemData systemData) {
        this.innerModel().withSystemData(systemData);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
