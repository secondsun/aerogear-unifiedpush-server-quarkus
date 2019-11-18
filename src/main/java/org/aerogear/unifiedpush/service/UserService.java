package org.aerogear.unifiedpush.service;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    /**
     * Extract the username to be used in multiple queries
     *
     * @return current logged in user
     */
    @Produces
    @LoggedIn
    public String extractUsername() {

        // final KeycloakPrincipal principal = (KeycloakPrincipal) httpServletRequest.getUserPrincipal();
        // if (principal != null) {
        //     logger.debug("Running with Keycloak context");
        //     KeycloakSecurityContext kcSecurityContext = principal.getKeycloakSecurityContext();
        //     return kcSecurityContext.getToken().getPreferredUsername();
        // }

        // logger.debug("Running outside of Keycloak context");
        // final String basicUsername = HttpBasicHelper.extractUsernameAndPasswordFromBasicHeader(httpServletRequest)[0];
        // if (! basicUsername.isEmpty()) {
        //     logger.debug("running HttpBasic auth");
        //     return basicUsername;
        // }

        logger.debug("Running without any Auth context");
        return "admin"; // by default, we are admin!
    }

}