// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.support.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.support.models.ContactProfile;
import com.azure.resourcemanager.support.models.QuotaTicketDetails;
import com.azure.resourcemanager.support.models.ServiceLevelAgreement;
import com.azure.resourcemanager.support.models.SeverityLevel;
import com.azure.resourcemanager.support.models.SupportEngineer;
import com.azure.resourcemanager.support.models.TechnicalTicketDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Object that represents SupportTicketDetails resource. */
@JsonFlatten
@Fluent
public class SupportTicketDetailsInner extends ProxyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SupportTicketDetailsInner.class);

    /*
     * System generated support ticket Id that is unique.
     */
    @JsonProperty(value = "properties.supportTicketId")
    private String supportTicketId;

    /*
     * Detailed description of the question or issue.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /*
     * Each Azure service has its own set of issue categories, also known as
     * problem classification. This parameter is the unique Id for the type of
     * problem you are experiencing.
     */
    @JsonProperty(value = "properties.problemClassificationId")
    private String problemClassificationId;

    /*
     * Localized name of problem classification.
     */
    @JsonProperty(value = "properties.problemClassificationDisplayName", access = JsonProperty.Access.WRITE_ONLY)
    private String problemClassificationDisplayName;

    /*
     * A value that indicates the urgency of the case, which in turn determines
     * the response time according to the service level agreement of the
     * technical support plan you have with Azure. Note: 'Highest critical
     * impact', also known as the 'Emergency - Severe impact' level in the
     * Azure portal is reserved only for our Premium customers.
     */
    @JsonProperty(value = "properties.severity")
    private SeverityLevel severity;

    /*
     * Enrollment Id associated with the support ticket.
     */
    @JsonProperty(value = "properties.enrollmentId", access = JsonProperty.Access.WRITE_ONLY)
    private String enrollmentId;

    /*
     * Indicates if this requires a 24x7 response from Azure.
     */
    @JsonProperty(value = "properties.require24X7Response")
    private Boolean require24X7Response;

    /*
     * Contact information of the user requesting to create a support ticket.
     */
    @JsonProperty(value = "properties.contactDetails")
    private ContactProfile contactDetails;

    /*
     * Service Level Agreement information for this support ticket.
     */
    @JsonProperty(value = "properties.serviceLevelAgreement")
    private ServiceLevelAgreement serviceLevelAgreement;

    /*
     * Information about the support engineer working on this support ticket.
     */
    @JsonProperty(value = "properties.supportEngineer")
    private SupportEngineer supportEngineer;

    /*
     * Support plan type associated with the support ticket.
     */
    @JsonProperty(value = "properties.supportPlanType", access = JsonProperty.Access.WRITE_ONLY)
    private String supportPlanType;

    /*
     * Title of the support ticket.
     */
    @JsonProperty(value = "properties.title")
    private String title;

    /*
     * Time in UTC (ISO 8601 format) when the problem started.
     */
    @JsonProperty(value = "properties.problemStartTime")
    private OffsetDateTime problemStartTime;

    /*
     * This is the resource Id of the Azure service resource associated with
     * the support ticket.
     */
    @JsonProperty(value = "properties.serviceId")
    private String serviceId;

    /*
     * Localized name of the Azure service.
     */
    @JsonProperty(value = "properties.serviceDisplayName", access = JsonProperty.Access.WRITE_ONLY)
    private String serviceDisplayName;

    /*
     * Status of the support ticket.
     */
    @JsonProperty(value = "properties.status", access = JsonProperty.Access.WRITE_ONLY)
    private String status;

    /*
     * Time in UTC (ISO 8601 format) when the support ticket was created.
     */
    @JsonProperty(value = "properties.createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime createdDate;

    /*
     * Time in UTC (ISO 8601 format) when the support ticket was last modified.
     */
    @JsonProperty(value = "properties.modifiedDate", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime modifiedDate;

    /*
     * Additional ticket details associated with a technical support ticket
     * request.
     */
    @JsonProperty(value = "properties.technicalTicketDetails")
    private TechnicalTicketDetails technicalTicketDetails;

    /*
     * Additional ticket details associated with a quota support ticket
     * request.
     */
    @JsonProperty(value = "properties.quotaTicketDetails")
    private QuotaTicketDetails quotaTicketDetails;

    /**
     * Get the supportTicketId property: System generated support ticket Id that is unique.
     *
     * @return the supportTicketId value.
     */
    public String supportTicketId() {
        return this.supportTicketId;
    }

    /**
     * Set the supportTicketId property: System generated support ticket Id that is unique.
     *
     * @param supportTicketId the supportTicketId value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withSupportTicketId(String supportTicketId) {
        this.supportTicketId = supportTicketId;
        return this;
    }

    /**
     * Get the description property: Detailed description of the question or issue.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Detailed description of the question or issue.
     *
     * @param description the description value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the problemClassificationId property: Each Azure service has its own set of issue categories, also known as
     * problem classification. This parameter is the unique Id for the type of problem you are experiencing.
     *
     * @return the problemClassificationId value.
     */
    public String problemClassificationId() {
        return this.problemClassificationId;
    }

    /**
     * Set the problemClassificationId property: Each Azure service has its own set of issue categories, also known as
     * problem classification. This parameter is the unique Id for the type of problem you are experiencing.
     *
     * @param problemClassificationId the problemClassificationId value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withProblemClassificationId(String problemClassificationId) {
        this.problemClassificationId = problemClassificationId;
        return this;
    }

    /**
     * Get the problemClassificationDisplayName property: Localized name of problem classification.
     *
     * @return the problemClassificationDisplayName value.
     */
    public String problemClassificationDisplayName() {
        return this.problemClassificationDisplayName;
    }

    /**
     * Get the severity property: A value that indicates the urgency of the case, which in turn determines the response
     * time according to the service level agreement of the technical support plan you have with Azure. Note: 'Highest
     * critical impact', also known as the 'Emergency - Severe impact' level in the Azure portal is reserved only for
     * our Premium customers.
     *
     * @return the severity value.
     */
    public SeverityLevel severity() {
        return this.severity;
    }

    /**
     * Set the severity property: A value that indicates the urgency of the case, which in turn determines the response
     * time according to the service level agreement of the technical support plan you have with Azure. Note: 'Highest
     * critical impact', also known as the 'Emergency - Severe impact' level in the Azure portal is reserved only for
     * our Premium customers.
     *
     * @param severity the severity value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withSeverity(SeverityLevel severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Get the enrollmentId property: Enrollment Id associated with the support ticket.
     *
     * @return the enrollmentId value.
     */
    public String enrollmentId() {
        return this.enrollmentId;
    }

    /**
     * Get the require24X7Response property: Indicates if this requires a 24x7 response from Azure.
     *
     * @return the require24X7Response value.
     */
    public Boolean require24X7Response() {
        return this.require24X7Response;
    }

    /**
     * Set the require24X7Response property: Indicates if this requires a 24x7 response from Azure.
     *
     * @param require24X7Response the require24X7Response value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withRequire24X7Response(Boolean require24X7Response) {
        this.require24X7Response = require24X7Response;
        return this;
    }

    /**
     * Get the contactDetails property: Contact information of the user requesting to create a support ticket.
     *
     * @return the contactDetails value.
     */
    public ContactProfile contactDetails() {
        return this.contactDetails;
    }

    /**
     * Set the contactDetails property: Contact information of the user requesting to create a support ticket.
     *
     * @param contactDetails the contactDetails value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withContactDetails(ContactProfile contactDetails) {
        this.contactDetails = contactDetails;
        return this;
    }

    /**
     * Get the serviceLevelAgreement property: Service Level Agreement information for this support ticket.
     *
     * @return the serviceLevelAgreement value.
     */
    public ServiceLevelAgreement serviceLevelAgreement() {
        return this.serviceLevelAgreement;
    }

    /**
     * Set the serviceLevelAgreement property: Service Level Agreement information for this support ticket.
     *
     * @param serviceLevelAgreement the serviceLevelAgreement value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withServiceLevelAgreement(ServiceLevelAgreement serviceLevelAgreement) {
        this.serviceLevelAgreement = serviceLevelAgreement;
        return this;
    }

    /**
     * Get the supportEngineer property: Information about the support engineer working on this support ticket.
     *
     * @return the supportEngineer value.
     */
    public SupportEngineer supportEngineer() {
        return this.supportEngineer;
    }

    /**
     * Set the supportEngineer property: Information about the support engineer working on this support ticket.
     *
     * @param supportEngineer the supportEngineer value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withSupportEngineer(SupportEngineer supportEngineer) {
        this.supportEngineer = supportEngineer;
        return this;
    }

    /**
     * Get the supportPlanType property: Support plan type associated with the support ticket.
     *
     * @return the supportPlanType value.
     */
    public String supportPlanType() {
        return this.supportPlanType;
    }

    /**
     * Get the title property: Title of the support ticket.
     *
     * @return the title value.
     */
    public String title() {
        return this.title;
    }

    /**
     * Set the title property: Title of the support ticket.
     *
     * @param title the title value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get the problemStartTime property: Time in UTC (ISO 8601 format) when the problem started.
     *
     * @return the problemStartTime value.
     */
    public OffsetDateTime problemStartTime() {
        return this.problemStartTime;
    }

    /**
     * Set the problemStartTime property: Time in UTC (ISO 8601 format) when the problem started.
     *
     * @param problemStartTime the problemStartTime value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withProblemStartTime(OffsetDateTime problemStartTime) {
        this.problemStartTime = problemStartTime;
        return this;
    }

    /**
     * Get the serviceId property: This is the resource Id of the Azure service resource associated with the support
     * ticket.
     *
     * @return the serviceId value.
     */
    public String serviceId() {
        return this.serviceId;
    }

    /**
     * Set the serviceId property: This is the resource Id of the Azure service resource associated with the support
     * ticket.
     *
     * @param serviceId the serviceId value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * Get the serviceDisplayName property: Localized name of the Azure service.
     *
     * @return the serviceDisplayName value.
     */
    public String serviceDisplayName() {
        return this.serviceDisplayName;
    }

    /**
     * Get the status property: Status of the support ticket.
     *
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Get the createdDate property: Time in UTC (ISO 8601 format) when the support ticket was created.
     *
     * @return the createdDate value.
     */
    public OffsetDateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Get the modifiedDate property: Time in UTC (ISO 8601 format) when the support ticket was last modified.
     *
     * @return the modifiedDate value.
     */
    public OffsetDateTime modifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Get the technicalTicketDetails property: Additional ticket details associated with a technical support ticket
     * request.
     *
     * @return the technicalTicketDetails value.
     */
    public TechnicalTicketDetails technicalTicketDetails() {
        return this.technicalTicketDetails;
    }

    /**
     * Set the technicalTicketDetails property: Additional ticket details associated with a technical support ticket
     * request.
     *
     * @param technicalTicketDetails the technicalTicketDetails value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withTechnicalTicketDetails(TechnicalTicketDetails technicalTicketDetails) {
        this.technicalTicketDetails = technicalTicketDetails;
        return this;
    }

    /**
     * Get the quotaTicketDetails property: Additional ticket details associated with a quota support ticket request.
     *
     * @return the quotaTicketDetails value.
     */
    public QuotaTicketDetails quotaTicketDetails() {
        return this.quotaTicketDetails;
    }

    /**
     * Set the quotaTicketDetails property: Additional ticket details associated with a quota support ticket request.
     *
     * @param quotaTicketDetails the quotaTicketDetails value to set.
     * @return the SupportTicketDetailsInner object itself.
     */
    public SupportTicketDetailsInner withQuotaTicketDetails(QuotaTicketDetails quotaTicketDetails) {
        this.quotaTicketDetails = quotaTicketDetails;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (contactDetails() != null) {
            contactDetails().validate();
        }
        if (serviceLevelAgreement() != null) {
            serviceLevelAgreement().validate();
        }
        if (supportEngineer() != null) {
            supportEngineer().validate();
        }
        if (technicalTicketDetails() != null) {
            technicalTicketDetails().validate();
        }
        if (quotaTicketDetails() != null) {
            quotaTicketDetails().validate();
        }
    }
}
