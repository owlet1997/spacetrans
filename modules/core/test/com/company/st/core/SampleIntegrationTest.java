package com.company.st.core;

import com.company.st.StTestContainer;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.spaceport.Carrier;
import com.company.st.entity.spaceport.Dimensions;
import com.company.st.entity.spaceport.SpacePort;
import com.company.st.entity.waybill.WayBill;
import com.company.st.entity.waybill.WayBillItem;
import com.company.st.service.ChargeCountWaybillItemService;
import com.company.st.service.ChargeCountWaybillItemServiceBean;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.Logger;
import org.springframework.transaction.event.TransactionPhase;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SampleIntegrationTest {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SampleIntegrationTest.class);
    @RegisterExtension
    public static StTestContainer cont = StTestContainer.Common.INSTANCE;

    private static Metadata metadata;
    private static Persistence persistence;

    @javax.inject.Inject
    private static DataManager dataManager;

    @javax.inject.Inject
    private static ChargeCountWaybillItemService chargeCountWaybillItemService;

    @BeforeAll
    public static void beforeAll() throws Exception {
        metadata = cont.metadata();
        persistence = cont.persistence();
        dataManager = AppBeans.get(DataManager.class);
        chargeCountWaybillItemService = AppBeans.get("st_ChargeCountWaybillItemService");
    }

    @AfterAll
    public static void afterAll() throws Exception {
    }

    @Test
    public void testLoadUser() {
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            TypedQuery<User> query = em.createQuery(
                    "select u from sec$User u where u.login = :userLogin", User.class);
            query.setParameter("userLogin", "admin");
            List<User> users = query.getResultList();
            tx.commit();
            Assertions.assertEquals(1, users.size());
        }
    }

    @Test
    public void testCreateWayBill(){

            List<User> userList = dataManager.load(User.class)
                    .query("select u from sec$User u where u.login = :userLogin")
                    .parameter("userLogin", "admin")
                    .list();

            List<Customer> customerList = dataManager.load(Customer.class)
                    .query("select s from st_Customer s")
                    .list();

            List<SpacePort> spacePortList = dataManager.load(SpacePort.class)
                    .query("select s from st_SpacePort s")
                    .list();

            Carrier carrier = dataManager.load(Carrier.class)
                    .query("select s from st_Carrier s")
                    .one();

            WayBill wayBill = dataManager.create(WayBill.class);

            wayBill.setReference("test1");
            wayBill.setCreator(userList.get(0));
            wayBill.setShipper(customerList.get(0));
            wayBill.setConsignee(customerList.get(1));
            wayBill.setDeparturePort(spacePortList.get(0));
            wayBill.setDestinationPort(spacePortList.get(1));
            wayBill.setCarrier(carrier);

            List<WayBillItem> wayBillItemList = new ArrayList<>();
            CommitContext commitContext = new CommitContext();
            for (int i = 1; i <= 5; i++){
                WayBillItem wayBillItem = dataManager.create(WayBillItem.class);
                wayBillItem.setWayBill(wayBill);
                wayBillItem.setNumber(i);
                wayBillItem.setName("WayBillItem №"+i);
                wayBillItem.setWeight((double) i);
                Dimensions dimensions = dataManager.create(Dimensions.class);
                dimensions.setHeight((double) i);
                dimensions.setLength((double) i);
                dimensions.setWidth((double) i);
                wayBillItem.setCharge(BigDecimal.valueOf(i));
                wayBillItem.setDim(dimensions);
                commitContext.addInstanceToCommit(wayBillItem);
                wayBillItemList.add(wayBillItem);
            }

            wayBill.setItems(wayBillItemList);

            wayBill.setTotalCharge(chargeCountWaybillItemService.getTotalCharge(wayBill));
            double weight = chargeCountWaybillItemService.getTotalWeight(wayBill);
            wayBill.setTotalWeight(weight);
            commitContext.addInstanceToCommit(wayBill);
            dataManager.commit(commitContext);

            Assertions.assertEquals(15, wayBill.getTotalWeight());
            Assertions.assertEquals(12.75, wayBill.getTotalCharge());

            wayBill = dataManager.reload(wayBill,"new-wayBill-view");
            List<WayBillItem> list = wayBill.getItems();

            WayBillItem deletedItem = dataManager.load(WayBillItem.class)
                            .query("select s from st_WayBillItem s where s.number = 1")
                            .one();
            list.remove(deletedItem);

            dataManager.remove(deletedItem);
            wayBill.setItems(list);
            dataManager.commit(wayBill);

            wayBill = dataManager.reload(wayBill,"new-wayBill-view");

            Assertions.assertEquals(4, wayBill.getItems().size());
            Assertions.assertEquals(14, wayBill.getTotalWeight());
            Assertions.assertEquals(11.9, wayBill.getTotalCharge());

    }
}