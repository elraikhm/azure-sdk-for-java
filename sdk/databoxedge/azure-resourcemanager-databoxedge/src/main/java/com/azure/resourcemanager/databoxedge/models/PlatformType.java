// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databoxedge.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for PlatformType. */
public final class PlatformType extends ExpandableStringEnum<PlatformType> {
    /** Static value Windows for PlatformType. */
    public static final PlatformType WINDOWS = fromString("Windows");

    /** Static value Linux for PlatformType. */
    public static final PlatformType LINUX = fromString("Linux");

    /**
     * Creates or finds a PlatformType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PlatformType.
     */
    @JsonCreator
    public static PlatformType fromString(String name) {
        return fromString(name, PlatformType.class);
    }

    /** @return known PlatformType values. */
    public static Collection<PlatformType> values() {
        return values(PlatformType.class);
    }
}
