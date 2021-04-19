// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batchai.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ExecutionState. */
public final class ExecutionState extends ExpandableStringEnum<ExecutionState> {
    /** Static value queued for ExecutionState. */
    public static final ExecutionState QUEUED = fromString("queued");

    /** Static value running for ExecutionState. */
    public static final ExecutionState RUNNING = fromString("running");

    /** Static value terminating for ExecutionState. */
    public static final ExecutionState TERMINATING = fromString("terminating");

    /** Static value succeeded for ExecutionState. */
    public static final ExecutionState SUCCEEDED = fromString("succeeded");

    /** Static value failed for ExecutionState. */
    public static final ExecutionState FAILED = fromString("failed");

    /**
     * Creates or finds a ExecutionState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ExecutionState.
     */
    @JsonCreator
    public static ExecutionState fromString(String name) {
        return fromString(name, ExecutionState.class);
    }

    /** @return known ExecutionState values. */
    public static Collection<ExecutionState> values() {
        return values(ExecutionState.class);
    }
}
