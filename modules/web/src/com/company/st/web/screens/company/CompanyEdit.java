package com.company.st.web.screens.company;

import com.company.st.entity.customer.Customer;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Company;

import javax.inject.Inject;

@UiController("st_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
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