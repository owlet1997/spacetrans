package com.company.st.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "ST_COMPANY")
@Entity(name = "st_Company")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Company extends Customer {
    private static final long serialVersionUID = -8694305012431362271L;

    @NotNull
    @Column(name = "REGISTRATION_ID", nullable = false, length = 100)
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