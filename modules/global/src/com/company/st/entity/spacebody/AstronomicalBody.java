package com.company.st.entity.spacebody;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@NamePattern("%s|name")
public class AstronomicalBody extends StandardEntity {
    private static final long serialVersionUID = -8320736721958572117L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "MASS", nullable = false)
    private Double mass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PICTURE_ID")
    private FileDescriptor picture;

    public FileDescriptor getPicture() {
        return picture;
    }

    public void setPicture(FileDescriptor picture) {
        this.picture = picture;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}