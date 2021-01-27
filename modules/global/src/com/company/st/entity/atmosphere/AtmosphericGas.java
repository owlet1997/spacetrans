package com.company.st.entity.atmosphere;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "ST_ATMOSPHERIC_GAS")
@Entity(name = "st_AtmosphericGas")
@NamePattern("%s|volume")
public class AtmosphericGas extends StandardEntity {
    private static final long serialVersionUID = 7091520209826167207L;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GAS_ID")
    private Gas gas;

    @NotNull
    @Column(name = "VOLUME", nullable = false)
    private Double volume;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ATMOSPHERE_ID")
    private Atmosphere atmosphere;

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume =  Math.round(volume * 100.0) / 100.0;;
    }

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }
}