package com.company.st.entity.customer;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("C")
@Table(name = "ST_CUSTOMER")
@Entity(name = "st_Customer")
@NamePattern("%s|name")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -803299922283881761L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    @Email
    private String email;

    @NotNull
    @Column(name = "GRADE", nullable = false)
    private String grade;

    public CustomerGrade getGrade() {
        return grade == null ? null : CustomerGrade.fromId(grade);
    }

    public void setGrade(CustomerGrade grade) {
        this.grade = grade == null ? null : grade.getId();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}