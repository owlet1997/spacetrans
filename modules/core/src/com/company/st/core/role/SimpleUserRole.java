package com.company.st.core.role;

import com.company.st.entity.atmosphere.Atmosphere;
import com.company.st.entity.atmosphere.AtmosphericGas;
import com.company.st.entity.atmosphere.Gas;
import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.*;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;

@Role(name = SimpleUserRole.NAME, description = "Обычные пользователи: могут просматривать данные планетной системы без возможности редактирования, но учет накладных им недоступен;")
public class SimpleUserRole extends AnnotatedRoleDefinition {
    public final static String NAME = "SimpleUser";

    @ScreenAccess(screenIds = {"st_Planet.browse", "application-st", "st_AtmosphericGas.browse", "st_Atmosphere.browse", "st_Gas.browse", "st_Moon.browse", "administration", "st_Atmosphere.edit", "st_AtmosphericGas.edit", "st_Gas.edit", "st_Moon.edit", "st_Planet.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @SpecificAccess(permissions = {"cuba.gui.loginToClient", "cuba.gui.searchFolder.global", "cuba.gui.showInfo"})
    @Override
    public SpecificPermissionsContainer specificPermissions() {
        return super.specificPermissions();
    }

    @EntityAccess(entityClass = FileDescriptor.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Planet.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Moon.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Gas.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = AtmosphericGas.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Atmosphere.class, operations = EntityOp.READ)
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = FileDescriptor.class, view = "*")
    @EntityAttributeAccess(entityClass = Planet.class, view = "*")
    @EntityAttributeAccess(entityClass = Moon.class, view = "*")
    @EntityAttributeAccess(entityClass = Gas.class, view = "*")
    @EntityAttributeAccess(entityClass = AtmosphericGas.class, view = "*")
    @EntityAttributeAccess(entityClass = Atmosphere.class, view = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}
