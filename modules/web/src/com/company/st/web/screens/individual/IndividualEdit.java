package com.company.st.web.screens.individual;

import com.company.st.entity.customer.Customer;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Individual;

import javax.inject.Inject;

@UiController("st_Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
@LoadDataBeforeShow
public class IndividualEdit extends StandardEditor<Individual> {
    @Inject
    private DataManager dataManager;
    @Inject
    private TextField<String> nameField;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        try{
            Customer customer = dataManager.load(Customer.class)
                    .query("select c from st_Customer c where c.name = :name")
                    .parameter("name", nameField.getValue())
                    .one();
            event.preventCommit();
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Пользователь с таким именем уже зарегистрирован!").show();
        } catch (IllegalStateException e){
            notifications.create().withCaption("Данное имя не занято!").show();
        }
    }
}