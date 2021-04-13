// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;

/** Resource collection API of LotsOperations. */
public interface LotsOperations {
    /**
     * Lists the lots by billingAccountId and billingProfileId.
     *
     * @param scope The scope associated with Lots operations. This includes
     *     '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfile/{billingProfileId}' for
     *     Billing Profile scope, and
     *     'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for
     *     partners.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing lot summary.
     */
    PagedIterable<LotSummary> list(String scope);

    /**
     * Lists the lots by billingAccountId and billingProfileId.
     *
     * @param scope The scope associated with Lots operations. This includes
     *     '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfile/{billingProfileId}' for
     *     Billing Profile scope, and
     *     'providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for
     *     partners.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of listing lot summary.
     */
    PagedIterable<LotSummary> list(String scope, Context context);
}
