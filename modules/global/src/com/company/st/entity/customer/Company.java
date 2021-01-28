package com.company.st.entity.customer;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "ST_COMPANY")
@Entity(name = "st_Company")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Company extends StandardEntity {
    private static final long serialVersionUID = -8694305012431362271L;

    @NotNull
    @Column(name = "REGISTRATION_ID", nullable = false, unique = true, length = 100)
    private String registrationId;

    @NotNull
    @Column(name = "COMPANY_TYPE", nullable = false, length = 100)
    private String companyType;

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}