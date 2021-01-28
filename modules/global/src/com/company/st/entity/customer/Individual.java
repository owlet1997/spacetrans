package com.company.st.entity.customer;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "ST_INDIVIDUAL")
@Entity(name = "st_Individual")
@NamePattern("%s|firstName")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Individual extends StandardEntity {
    private static final long serialVersionUID = 7386419496106512152L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}