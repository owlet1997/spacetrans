package com.company.st.core.role;

import com.company.st.entity.atmosphere.Atmosphere;
import com.company.st.entity.atmosphere.AtmosphericGas;
import com.company.st.entity.atmosphere.Gas;
import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Discounts;
import com.company.st.entity.customer.Individual;
import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.company.st.entity.spaceport.Carrier;
import com.company.st.entity.spaceport.Coordinates;
import com.company.st.entity.spaceport.Dimensions;
import com.company.st.entity.spaceport.SpacePort;
import com.company.st.entity.waybill.WayBill;
import com.company.st.entity.waybill.WayBillItem;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.*;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserSessionEntity;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;

@Role(name = OperatorRole.NAME, description = "Операторы: могут работать с накладными и клиентами, но не могут редактировать никакую справочную информацию;")
public class OperatorRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Operator";

    @ScreenAccess(screenIds = {"st_Planet.browse", "application-st", "st_AtmosphericGas.browse", "st_Atmosphere.browse", "st_Gas.browse", "st_Moon.browse", "st_Individual.browse", "st_Company.browse", "st_SpacePort.browse", "st_Discounts.browse", "st_WayBill.browse", "st_WayBillItem.browse", "st_Customer.browse", "st_Carrier.browse", "st_Company.edit", "st_Customer.edit", "st_Discounts.edit", "st_Individual.edit", "st_WayBill.edit", "st_WayBillItem.edit", "login", "loginWindow"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = UserSessionEntity.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = User.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = FileDescriptor.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = WayBillItem.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = WayBill.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = SpacePort.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Planet.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Moon.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Individual.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Gas.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Discounts.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Dimensions.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Customer.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Coordinates.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Company.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Carrier.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = AtmosphericGas.class, operations = EntityOp.READ)
    @EntityAccess(entityClass = Atmosphere.class, operations = EntityOp.READ)
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = UserSessionEntity.class, view = "*")
    @EntityAttributeAccess(entityClass = User.class, view = "*")
    @EntityAttributeAccess(entityClass = FileDescriptor.class, view = "*")
    @EntityAttributeAccess(entityClass = WayBillItem.class, modify = "*")
    @EntityAttributeAccess(entityClass = WayBill.class, modify = "*")
    @EntityAttributeAccess(entityClass = SpacePort.class, view = "*")
    @EntityAttributeAccess(entityClass = Planet.class, view = "*")
    @EntityAttributeAccess(entityClass = Moon.class, view = "*")
    @EntityAttributeAccess(entityClass = Individual.class, modify = "*")
    @EntityAttributeAccess(entityClass = Gas.class, view = "*")
    @EntityAttributeAccess(entityClass = Discounts.class, modify = "*")
    @EntityAttributeAccess(entityClass = Dimensions.class, modify = "*")
    @EntityAttributeAccess(entityClass = Customer.class, modify = "*")
    @EntityAttributeAccess(entityClass = Coordinates.class, view = "*")
    @EntityAttributeAccess(entityClass = Company.class, modify = "*")
    @EntityAttributeAccess(entityClass = Carrier.class, view = "*")
    @EntityAttributeAccess(entityClass = AtmosphericGas.class, view = "*")
    @EntityAttributeAccess(entityClass = Atmosphere.class, view = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @SpecificAccess(permissions = "cuba.gui.loginToClient")
    @Override
    public SpecificPermissionsContainer specificPermissions() {
        return super.specificPermissions();
    }
}
