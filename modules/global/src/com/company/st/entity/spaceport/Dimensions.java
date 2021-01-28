package com.company.st.entity.spaceport;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@MetaClass(name = "st_Dimensions")
@Embeddable
public class Dimensions extends EmbeddableEntity {
    private static final long serialVersionUID = -1136841139038481580L;

    @NotNull
    @Column(name = "LENGTH", nullable = false)
    private Double length;

    @NotNull
    @Column(name = "WIDTH", nullable = false)
    private Double width;

    @NotNull
    @Column(name = "HEIGHT", nullable = false)
    private Double height;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}