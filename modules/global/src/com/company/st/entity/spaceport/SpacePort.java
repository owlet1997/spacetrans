package com.company.st.entity.spaceport;

import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;
import com.haulmont.cuba.core.entity.annotation.Listeners;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Listeners("st_SpacePortChangedListener")
@Table(name = "ST_SPACE_PORT")
@Entity(name = "st_SpacePort")
@NamePattern("%s|name")
public class SpacePort extends StandardEntity {
    private static final long serialVersionUID = 2445131585808671507L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLANET_ID")
    private Planet planet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOON_ID")
    private Moon moon;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "COORDINATES_LATITUDE")),
            @AttributeOverride(name = "longtitude", column = @Column(name = "COORDINATES_LONGTITUDE"))
    })
    private Coordinates coordinates;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault = false;

    @JoinTable(name = "ST_CARRIER_SPACE_PORT_LINK",
            joinColumns = @JoinColumn(name = "SPACE_PORT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CARRIER_ID"))
    @ManyToMany
    private List<Carrier> carriers;

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Moon getMoon() {
        return moon;
    }

    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}