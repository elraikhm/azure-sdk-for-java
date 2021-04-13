// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;

/** Execute pipeline activity. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("ExecutePipeline")
@JsonFlatten
@Fluent
public class ExecutePipelineActivity extends ControlActivity {
    /*
     * Pipeline reference.
     */
    @JsonProperty(value = "typeProperties.pipeline", required = true)
    private PipelineReference pipeline;

    /*
     * Pipeline parameters.
     */
    @JsonProperty(value = "typeProperties.parameters")
    private Map<String, Object> parameters;

    /*
     * Defines whether activity execution will wait for the dependent pipeline
     * execution to finish. Default is false.
     */
    @JsonProperty(value = "typeProperties.waitOnCompletion")
    private Boolean waitOnCompletion;

    /**
     * Get the pipeline property: Pipeline reference.
     *
     * @return the pipeline value.
     */
    public PipelineReference getPipeline() {
        return this.pipeline;
    }

    /**
     * Set the pipeline property: Pipeline reference.
     *
     * @param pipeline the pipeline value to set.
     * @return the ExecutePipelineActivity object itself.
     */
    public ExecutePipelineActivity setPipeline(PipelineReference pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /**
     * Get the parameters property: Pipeline parameters.
     *
     * @return the parameters value.
     */
    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Pipeline parameters.
     *
     * @param parameters the parameters value to set.
     * @return the ExecutePipelineActivity object itself.
     */
    public ExecutePipelineActivity setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the waitOnCompletion property: Defines whether activity execution will wait for the dependent pipeline
     * execution to finish. Default is false.
     *
     * @return the waitOnCompletion value.
     */
    public Boolean isWaitOnCompletion() {
        return this.waitOnCompletion;
    }

    /**
     * Set the waitOnCompletion property: Defines whether activity execution will wait for the dependent pipeline
     * execution to finish. Default is false.
     *
     * @param waitOnCompletion the waitOnCompletion value to set.
     * @return the ExecutePipelineActivity object itself.
     */
    public ExecutePipelineActivity setWaitOnCompletion(Boolean waitOnCompletion) {
        this.waitOnCompletion = waitOnCompletion;
        return this;
    }
}
