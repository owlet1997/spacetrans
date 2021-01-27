package com.company.st.entity.atmosphere;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "ST_ATMOSPHERE")
@Entity(name = "st_Atmosphere")
@NamePattern("%s|description")
public class Atmosphere extends StandardEntity {
    private static final long serialVersionUID = 1427797692713269185L;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRESSURE")
    private Double pressure;

    @Composition
    @OneToMany(mappedBy = "atmosphere")
    private List<AtmosphericGas> gases;

    public List<AtmosphericGas> getGases() {
        return gases;
    }

    public void setGases(List<AtmosphericGas> gases) {
        this.gases = gases;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}