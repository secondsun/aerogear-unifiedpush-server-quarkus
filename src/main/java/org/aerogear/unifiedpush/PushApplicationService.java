package org.aerogear.unifiedpush;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.validation.Valid;

import org.aerogear.unifiedpush.model.PushApplication;
import org.aerogear.unifiedpush.service.LoggedIn;

import io.quarkus.hibernate.orm.panache.Panache;

@ApplicationScoped
public class PushApplicationService {


    @Inject
    @LoggedIn
    Instance<String> loginName;

    public void validateModelClass(@Valid PushApplication pushApplication) {
        //method body intentionally empty
    }

    public void addPushApplication(PushApplication pushApp) {
        final String id = pushApp.getPushApplicationID();

        

        if (PushApplication.findByPushApplicationID(id) != null) {
            throw new IllegalArgumentException("App ID already exists: " + id);
        }

        try {
            pushApp.setDeveloper(loginName.get());
            PushApplication.persist(pushApp);
            Panache.getEntityManager().flush();
            Panache.getEntityManager().clear();
        } catch (RuntimeException e) {
            throw new RuntimeException("Transaction failed for app with ID: " + id, e);
        }
    }

}
