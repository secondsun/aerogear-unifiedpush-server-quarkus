package org.aerogear.unifiedpush.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PushApplication extends PanacheEntity {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Size(min = 1, max = 255)
    private String description;

    /**
     * why having this if we already have an id?
     *
     * look at it like an API key, which is subject to change
     */
    private String pushApplicationID = UUID.randomUUID().toString();
    private String masterSecret = UUID.randomUUID().toString();

    @Size(min = 1, max = 255)
    private String developer;

    @OneToMany(targetEntity=Variant.class, fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="push_application_id")
    private List<Variant> variants = new ArrayList<>();

    /**
     * The name of the application.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * The description of the app.
     *
     * @param description the description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Identifier used to register variants with this PushApplication
     *
     * @param pushApplicationID the pushApplicationID
     */
    public void setPushApplicationID(String pushApplicationID) {
        this.pushApplicationID = pushApplicationID;
    }

    public String getPushApplicationID() {
        return pushApplicationID;
    }

    /**
     * The master password, used for sending message to a {@link PushApplication} or its {@link Variant}s.
     *
     * @param masterSecret the masterSecret
     */
    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }

    public String getMasterSecret() {
        return masterSecret;
    }


    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    /**
     * The developer which created the app.
     *
     * @return the owning developer
     */
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

	public static PushApplication findByPushApplicationID(String id) {
		return find("pushApplicationID", id).firstResult();
	}
}
