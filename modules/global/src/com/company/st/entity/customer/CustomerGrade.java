package com.company.st.entity.customer;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CustomerGrade implements EnumClass<String> {

    BRONZE("bronze grade"),
    SILVER("silver grade"),
    GOLD("gold grade");

    private String id;

    CustomerGrade(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CustomerGrade fromId(String id) {
        for (CustomerGrade at : CustomerGrade.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}