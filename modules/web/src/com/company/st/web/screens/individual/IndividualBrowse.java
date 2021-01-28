package com.company.st.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Individual;

@UiController("st_Individual.browse")
@UiDescriptor("individual-browse.xml")
@LookupComponent("individualsTable")
@LoadDataBeforeShow
public class IndividualBrowse extends StandardLookup<Individual> {
}