package com.company.st.entity.spaceport;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@MetaClass(name = "st_Coordinates")
@Embeddable
public class Coordinates extends EmbeddableEntity {
    private static final long serialVersionUID = 8079556456913877029L;

    @NotNull
    @Column(name = "LATITUDE", nullable = false)
    @NumberFormat(pattern = "#.######")
    private Double latitude;

    @Column(name = "LONGTITUDE", nullable = false)
    @NotNull
    @NumberFormat(pattern = "#.######")
    private Double longtitude;

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}