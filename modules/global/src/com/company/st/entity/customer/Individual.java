package com.company.st.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "ST_INDIVIDUAL")
@Entity(name = "st_Individual")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Individual extends Customer {
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