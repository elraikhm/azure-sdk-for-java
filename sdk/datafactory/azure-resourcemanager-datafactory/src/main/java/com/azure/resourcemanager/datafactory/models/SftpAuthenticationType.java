// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SftpAuthenticationType. */
public final class SftpAuthenticationType extends ExpandableStringEnum<SftpAuthenticationType> {
    /** Static value Basic for SftpAuthenticationType. */
    public static final SftpAuthenticationType BASIC = fromString("Basic");

    /** Static value SshPublicKey for SftpAuthenticationType. */
    public static final SftpAuthenticationType SSH_PUBLIC_KEY = fromString("SshPublicKey");

    /** Static value MultiFactor for SftpAuthenticationType. */
    public static final SftpAuthenticationType MULTI_FACTOR = fromString("MultiFactor");

    /**
     * Creates or finds a SftpAuthenticationType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SftpAuthenticationType.
     */
    @JsonCreator
    public static SftpAuthenticationType fromString(String name) {
        return fromString(name, SftpAuthenticationType.class);
    }

    /** @return known SftpAuthenticationType values. */
    public static Collection<SftpAuthenticationType> values() {
        return values(SftpAuthenticationType.class);
    }
}
