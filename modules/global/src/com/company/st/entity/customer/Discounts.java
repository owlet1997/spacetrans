package com.company.st.entity.customer;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Table(name = "ST_DISCOUNTS")
@Entity(name = "st_Discounts")
public class Discounts extends StandardEntity {
    private static final long serialVersionUID = -7671748137393228015L;

    @NotNull
    @Column(name = "GRADE", nullable = false, unique = true)
    private String grade;

    @NotNull
    @Column(name = "VALUE_", nullable = false, unique = true)
    @DecimalMin("0")
    @DecimalMax("100")
    @PositiveOrZero
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CustomerGrade getGrade() {
        return grade == null ? null : CustomerGrade.fromId(grade);
    }

    public void setGrade(CustomerGrade grade) {
        this.grade = grade == null ? null : grade.getId();
    }
}