package org.aerogear.unifiedpush.service;

import javax.enterprise.context.RequestScoped;

import org.aerogear.unifiedpush.model.PushApplication;
import org.aerogear.unifiedpush.service.dashboard.DashboardData;

@RequestScoped
public class SearchManager {

    public DashboardData loadDashboardData() {

        long totalApps = PushApplication.count();
        long totalDevices = 0;
        long totalMessages = 0;


        final DashboardData data = new DashboardData();
        data.setApplications(totalApps);
        data.setDevices(totalDevices);
        data.setMessages(totalMessages);

        return data;
    }

}
