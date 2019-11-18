package org.aerogear.unifiedpush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.aerogear.unifiedpush.model.PushApplication;

@Path("applications")
public class ApplicationsResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Inject
    PushApplicationService pushAppService;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerPushApplication(PushApplication pushApp) {

        try {
            pushAppService.validateModelClass(pushApp);
        } catch (ConstraintViolationException cve) {
            logger.trace("Unable to create Push Application");
            return createBadRequestResponse(cve.getConstraintViolations()).build();
        }

        try {
            logger.trace("Invoke service to create a push application");
            pushAppService.addPushApplication(pushApp);
        } catch (IllegalArgumentException e) {
            return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
        }

        final URI uri = UriBuilder.fromResource(ApplicationsResource.class)
                .path(pushApp.getPushApplicationID())
                .build();

        return Response
                .created(uri)
                .entity(pushApp)
                .build();
    }

    /**
     * Helper function to create a 400 Bad Request response, containing a JSON map giving details about the violations
     * 
     * @param violations set of occurred constraint violations
     * @return 400 Bad Request response, containing details on the constraint violations 
     */
    protected ResponseBuilder createBadRequestResponse(Set<ConstraintViolation<?>> violations) {
        final Map<String, String> responseObj = violations.stream()
                .collect(Collectors.toMap(v -> v.getPropertyPath().toString(), ConstraintViolation::getMessage));

        return Response.status(Response.Status.BAD_REQUEST)
                           .entity(responseObj);
    }

}