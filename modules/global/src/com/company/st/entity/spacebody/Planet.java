package com.company.st.entity.spacebody;

import com.company.st.entity.atmosphere.Atmosphere;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.text.ParseException;

@Table(name = "ST_PLANET")
@Entity(name = "st_Planet")
@NamePattern("%s|version")
public class Planet extends AstronomicalBody {
    private static final long serialVersionUID = -5479335096032671490L;

    @NotNull
    @Column(name = "SEMI_MAJOR_AXES", nullable = false)
    private Double semiMajorAxes;

    @NotNull
    @Column(name = "ORBITAL_PERIOD", nullable = false)
    private Double orbitalPeriod;

    @Column(name = "ROTATION_PERIOD")
    private Double rotationPeriod;

    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATMOSPHERE_ID")
    private Atmosphere atmosphere;

    @NotNull
    @Column(name = "RINGS", nullable = false)
    private Boolean rings = false;

    public Boolean getRings() {
        return rings;
    }

    public void setRings(Boolean rings) {
        this.rings = rings;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) throws ParseException {
        this.rotationPeriod = Double.valueOf(rotationPeriod);
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) throws ParseException {
        this.orbitalPeriod = Double.valueOf(orbitalPeriod);
    }

    public Double getSemiMajorAxes() {
        return semiMajorAxes;
    }

    public void setSemiMajorAxes(String semiMajorAxes) throws ParseException {
        this.semiMajorAxes = Double.valueOf(semiMajorAxes);
    }
}