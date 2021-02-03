package com.company.st.service;

import com.company.st.entity.customer.CustomerGrade;
import com.company.st.entity.waybill.WayBill;
import com.company.st.entity.waybill.WayBillItem;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

@Service(ChargeCountWaybillItemService.NAME)
public class ChargeCountWaybillItemServiceBean implements ChargeCountWaybillItemService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ChargeCountWaybillItemServiceBean.class);
    @Inject
    private DataManager dataManager;

    @Override
    public double getChargeValue(double[] arr) {
        return (arr[0] + arr[1] + arr[2])*arr[3];
    }

    @Override
    public double getTotalCharge(WayBill wayBill) {
        try{
            double totalCharge = 0;
            double charge = wayBill.getItems().stream().map(WayBillItem::getCharge).mapToDouble(e -> e.doubleValue()).sum();
            CustomerGrade grade = wayBill.getShipper().getGrade();
            double discount = dataManager.loadValue("select e.value from st_Discounts e where e.grade = :grade", BigDecimal.class)
                    .parameter("grade", grade.getId())
                    .one().doubleValue();
            totalCharge = (charge * (100 - discount)) / 100;
            return totalCharge;
        } catch (NullPointerException e){
            log.error("List is empty", e);
            return 0;
        }
    }

    @Override
    public double getTotalWeight(WayBill wayBill) {
        try{
            double totalWeight = 0;
            totalWeight = wayBill.getItems().stream().mapToDouble(WayBillItem::getWeight).sum();
            return totalWeight;
        } catch (NullPointerException e){
            log.error("List is empty", e);
            return 0;
        }
    }


}