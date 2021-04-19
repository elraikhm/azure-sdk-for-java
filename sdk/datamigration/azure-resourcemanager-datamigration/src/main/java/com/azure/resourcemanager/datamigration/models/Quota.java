// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.resourcemanager.datamigration.fluent.models.QuotaInner;

/** An immutable client-side representation of Quota. */
public interface Quota {
    /**
     * Gets the currentValue property: The current value of the quota. If null or missing, the current value cannot be
     * determined in the context of the request.
     *
     * @return the currentValue value.
     */
    Double currentValue();

    /**
     * Gets the id property: The resource ID of the quota object.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the limit property: The maximum value of the quota. If null or missing, the quota has no maximum, in which
     * case it merely tracks usage.
     *
     * @return the limit value.
     */
    Double limit();

    /**
     * Gets the name property: The name of the quota.
     *
     * @return the name value.
     */
    QuotaName name();

    /**
     * Gets the unit property: The unit for the quota, such as Count, Bytes, BytesPerSecond, etc.
     *
     * @return the unit value.
     */
    String unit();

    /**
     * Gets the inner com.azure.resourcemanager.datamigration.fluent.models.QuotaInner object.
     *
     * @return the inner object.
     */
    QuotaInner innerModel();
}
