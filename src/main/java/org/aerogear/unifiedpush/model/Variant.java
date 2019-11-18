package org.aerogear.unifiedpush.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public abstract class Variant extends PanacheEntity {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Size(min = 0, max = 255)
    private String description;

    private String variantID = UUID.randomUUID().toString();

    private String secret = UUID.randomUUID().toString();

    private String developer;

    /**
     * The @VariantType of the underlying variant.
     *
     * @return the variant type
     */
    public abstract VariantType getType();

    //ugly way to make it a immutable property
    public void setType(VariantType type) {}

    public String getName() {
        return this.name;
    }

    /**
     * The name of the variant (e.g. the name of the matching App in the Appstore)
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Some description of the app.
     *
     * @param description the description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    public String getVariantID() {
        return variantID;
    }

    /**
     * Identifier used to register an {@link Installation} with this Variant
     *
     * @param variantID the variant ID
     */
    public void setVariantID(String variantID) {
        this.variantID = variantID;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
