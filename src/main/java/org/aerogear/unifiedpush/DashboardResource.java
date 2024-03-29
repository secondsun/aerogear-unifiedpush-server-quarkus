package org.aerogear.unifiedpush;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import org.aerogear.unifiedpush.service.SearchManager;
import org.aerogear.unifiedpush.service.dashboard.ApplicationVariant;
import org.aerogear.unifiedpush.service.dashboard.DashboardData;

@Path("/metrics/dashboard")
public class DashboardResource {


    @Inject
    private SearchManager service;
    
    /**
     * GET dashboard data
     *
     * @param request the request
     *
     * @return  {@link DashboardData} for the given user
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalApplications() {
        final DashboardData dataForUser = service.loadDashboardData();
        
        return Response.ok(dataForUser).build();
    }

    @GET
    @Path("warnings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVariantsWithWarnings() {
        final List<ApplicationVariant> variantsWithWarnings = new ArrayList<>();

        return Response.ok(variantsWithWarnings).build();
    }
}