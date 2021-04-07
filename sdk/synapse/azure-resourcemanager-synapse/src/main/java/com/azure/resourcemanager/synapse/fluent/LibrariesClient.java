// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.synapse.fluent.models.LibraryResourceInner;

/** An instance of this class provides access to all the operations defined in LibrariesClient. */
public interface LibrariesClient {
    /**
     * Get library by name in a workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param libraryName Library name.
     * @param workspaceName The name of the workspace.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return library by name in a workspace.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LibraryResourceInner get(String resourceGroupName, String libraryName, String workspaceName);

    /**
     * Get library by name in a workspace.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param libraryName Library name.
     * @param workspaceName The name of the workspace.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return library by name in a workspace.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LibraryResourceInner> getWithResponse(
        String resourceGroupName, String libraryName, String workspaceName, Context context);
}
