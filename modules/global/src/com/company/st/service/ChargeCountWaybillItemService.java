package com.company.st.service;

import com.company.st.entity.waybill.WayBill;
import com.company.st.entity.waybill.WayBillItem;

import java.math.BigDecimal;

public interface ChargeCountWaybillItemService {
    String NAME = "st_ChargeCountWaybillItemService";

    double getChargeValue(double[] arr);

    double getTotalCharge(WayBill wayBill);

    double getTotalWeight(WayBill wayBill);
}