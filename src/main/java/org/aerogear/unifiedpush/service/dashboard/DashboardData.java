package org.aerogear.unifiedpush.service.dashboard;

public class DashboardData {
    private long applications;
    private long devices;
    private long messages;

    /**
     * Number of push applications of the current user.
     *
     * @return number of users
     */
    public long getApplications() {
        return applications;
    }

    public void setApplications(long applications) {
        this.applications = applications;
    }

    /**
     * Number of registered devices for the push applications of the current user.
     *
     * @return number of devices
     */
    public long getDevices() {
        return devices;
    }

    public void setDevices(long devices) {
        this.devices = devices;
    }

    /**
     * Number of sent messages from push applications of the current user.
     *
     * @return number of messages
     */
    public long getMessages() {
        return messages;
    }

    public void setMessages(long messages) {
        this.messages = messages;
    }
}