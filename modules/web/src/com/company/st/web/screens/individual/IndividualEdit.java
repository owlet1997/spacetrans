package com.company.st.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Individual;

@UiController("st_Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
@LoadDataBeforeShow
public class IndividualEdit extends StandardEditor<Individual> {
}