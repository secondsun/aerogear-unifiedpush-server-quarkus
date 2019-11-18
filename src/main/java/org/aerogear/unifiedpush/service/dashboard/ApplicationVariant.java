package org.aerogear.unifiedpush.service.dashboard;

import org.aerogear.unifiedpush.model.PushApplication;
import org.aerogear.unifiedpush.model.Variant;

public class ApplicationVariant {
    private Variant variant;
    private String applicationName;
    private String applicationID;
    private Long receivers;

    public ApplicationVariant(PushApplication application, Variant variant) {
        this.applicationID = application.getPushApplicationID();
        this.applicationName = application.getName();
        this.variant = variant;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Long getReceivers() {
        return receivers;
    }

    public void setReceivers(Long receivers) {
        this.receivers = receivers;
    }


    @Override
    public String toString() {
        return "ApplicationVariant{" +
                "variant=" + variant +
                ", applicationName='" + applicationName + '\'' +
                ", applicationId='" + applicationID + '\'' +
                '}';
    }
}