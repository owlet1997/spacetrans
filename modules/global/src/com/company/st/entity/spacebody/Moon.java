package com.company.st.entity.spacebody;

import com.company.st.entity.atmosphere.Atmosphere;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "ST_MOON")
@Entity(name = "st_Moon")
public class Moon extends AstronomicalBody {
    private static final long serialVersionUID = 4666981866587953803L;

    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATMOSPHERE_ID")
    private Atmosphere atmosphere;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PLANET_ID")
    private Planet planet;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }
}