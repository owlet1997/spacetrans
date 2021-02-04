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
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;
import com.haulmont.reports.entity.*;
import com.haulmont.reports.entity.wizard.ReportData;
import com.haulmont.reports.entity.wizard.ReportRegion;

@Role(name = ManagerRole.NAME, description = "Менеджеры: могут все работать со всеми прикладными объектами системы, но не имеют доступа к администрированию.")
public class ManagerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Manager";

    @ScreenAccess(screenIds = {"report$Report.browse", "reports", "report$ReportGroup.browse", "report$Report.run", "report$showChart", "report$showReportTable", "report$showPivotTable", "st_Planet.browse", "application-st", "st_AtmosphericGas.browse", "st_Atmosphere.browse", "st_Gas.browse", "st_Moon.browse", "st_Individual.browse", "st_Company.browse", "st_SpacePort.browse", "st_Discounts.browse", "st_WayBill.browse", "st_WayBillItem.browse", "st_Customer.browse", "st_Carrier.browse", "aboutWindow", "help", "settings", "st_Atmosphere.edit", "st_AtmosphericGas.edit", "st_Carrier.edit", "st_Company.edit", "st_Customer.edit", "st_Discounts.edit", "st_Gas.edit", "st_Individual.edit", "st_Moon.edit", "st_Planet.edit", "st_SpacePort.edit", "st_WayBill.edit", "st_WayBillItem.edit", "login", "loginWindow", "lookupWindowActions", "report$inputParameters", "report$inputParametersFrame", "report$Report.edit", "report$PivotTableEdit", "report$PivotTableAggregation.edit", "report$PivotTableProperty.edit", "report$ChartEdit", "report$BandDefinition.edit", "report$Report.importDialog", "report$Report.regionEditor", "report$Report.wizard", "report$ReportEntityTree.lookup", "report$ReportExecution.browse", "report$ReportExecution.dialog", "report$ReportGroup.edit", "report$ReportInputParameter.edit", "report$ReportTemplate.edit", "report$ReportValueFormat.edit", "report$TableEditFrame", "commonLookup"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = ReportValueFormat.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportTemplate.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportScreen.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportRegion.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportInputParameter.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportGroup.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportExecution.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = ReportData.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Report.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = FileDescriptor.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = WayBillItem.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = WayBill.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = SpacePort.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Planet.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Moon.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Individual.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Gas.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Discounts.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Dimensions.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Customer.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Coordinates.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Company.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Carrier.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = AtmosphericGas.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @EntityAccess(entityClass = Atmosphere.class, operations = {EntityOp.CREATE, EntityOp.UPDATE, EntityOp.READ, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = ReportValueFormat.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportTemplate.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportScreen.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportRegion.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportInputParameter.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportGroup.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportExecution.class, modify = "*")
    @EntityAttributeAccess(entityClass = ReportData.class, modify = "*")
    @EntityAttributeAccess(entityClass = Report.class, modify = "*")
    @EntityAttributeAccess(entityClass = FileDescriptor.class, modify = "*")
    @EntityAttributeAccess(entityClass = WayBillItem.class, modify = "*")
    @EntityAttributeAccess(entityClass = WayBill.class, modify = "*")
    @EntityAttributeAccess(entityClass = SpacePort.class, modify = "*")
    @EntityAttributeAccess(entityClass = Planet.class, modify = "*")
    @EntityAttributeAccess(entityClass = Moon.class, modify = "*")
    @EntityAttributeAccess(entityClass = Individual.class, modify = "*")
    @EntityAttributeAccess(entityClass = Gas.class, modify = "*")
    @EntityAttributeAccess(entityClass = Discounts.class, modify = "*")
    @EntityAttributeAccess(entityClass = Dimensions.class, modify = "*")
    @EntityAttributeAccess(entityClass = Customer.class, modify = "*")
    @EntityAttributeAccess(entityClass = Coordinates.class, modify = "*")
    @EntityAttributeAccess(entityClass = Company.class, modify = "*")
    @EntityAttributeAccess(entityClass = Carrier.class, modify = "*")
    @EntityAttributeAccess(entityClass = AtmosphericGas.class, modify = "*")
    @EntityAttributeAccess(entityClass = Atmosphere.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @SpecificAccess(permissions = {"cuba.gui.loginToClient", "cuba.gui.appFolder.global", "cuba.gui.bulkEdit", "cuba.gui.searchFolder.global", "cuba.gui.showExceptionDetails", "cuba.gui.showInfo", "cuba.gui.presentations.global", "cuba.gui.filter.customConditions", "cuba.gui.filter.edit", "cuba.gui.filter.global", "cuba.gui.filter.maxResults"})
    @Override
    public SpecificPermissionsContainer specificPermissions() {
        return super.specificPermissions();
    }
}
