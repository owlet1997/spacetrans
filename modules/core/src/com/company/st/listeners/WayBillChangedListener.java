package com.company.st.listeners;

import com.company.st.entity.waybill.WayBill;
import com.company.st.service.ChargeCountWaybillItemService;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.entity.User;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("st_WayBillChangedListener")
public class WayBillChangedListener {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(WayBillChangedListener.class);
    @Inject
    private TransactionalDataManager txDataManager;
    @Inject
    private ChargeCountWaybillItemService chargeCountWaybillItemService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<WayBill, UUID> event) {
        log.info(String.valueOf(event));

        WayBill wayBill = txDataManager.load(event.getEntityId()).one();

        AttributeChanges changes = event.getChanges();
        EntityChangedEvent.Type type = event.getType();
        if (type == EntityChangedEvent.Type.UPDATED){
            if (changes.isChanged("items")){
                wayBill.setTotalCharge(chargeCountWaybillItemService.getTotalCharge(wayBill));
                wayBill.setTotalWeight(chargeCountWaybillItemService.getTotalWeight(wayBill));
            }
        }
    }


}