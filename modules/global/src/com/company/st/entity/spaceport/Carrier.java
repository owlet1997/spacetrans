package com.company.st.entity.spaceport;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "ST_CARRIER")
@Entity(name = "st_Carrier")
@NamePattern("%s|name")
public class Carrier extends StandardEntity {
    private static final long serialVersionUID = -3318718640658737183L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;


    @JoinTable(name = "ST_CARRIER_SPACE_PORT_LINK",
            joinColumns = @JoinColumn(name = "CARRIER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPACE_PORT_ID"))
    @ManyToMany
    private List<SpacePort> ports;

    public List<SpacePort> getPorts() {
        return ports;
    }

    public void setPorts(List<SpacePort> ports) {
        this.ports = ports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}