// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The location of file server dataset. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("FileServerLocation")
@Immutable
public final class FileServerLocation extends DatasetLocation {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(FileServerLocation.class);

    /** {@inheritDoc} */
    @Override
    public FileServerLocation withFolderPath(Object folderPath) {
        super.withFolderPath(folderPath);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public FileServerLocation withFileName(Object fileName) {
        super.withFileName(fileName);
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
    }
}
