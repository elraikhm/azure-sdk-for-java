// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for OperatingSystemType. */
public enum OperatingSystemType {
    /** Enum value Windows. */
    WINDOWS("Windows"),

    /** Enum value Linux. */
    LINUX("Linux");

    /** The actual serialized value for a OperatingSystemType instance. */
    private final String value;

    OperatingSystemType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a OperatingSystemType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed OperatingSystemType object, or null if unable to parse.
     */
    @JsonCreator
    public static OperatingSystemType fromString(String value) {
        OperatingSystemType[] items = OperatingSystemType.values();
        for (OperatingSystemType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
