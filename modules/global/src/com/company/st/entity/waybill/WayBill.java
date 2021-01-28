package com.company.st.entity.waybill;

import com.company.st.entity.customer.Customer;
import com.company.st.entity.spaceport.Carrier;
import com.company.st.entity.spaceport.SpacePort;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "ST_WAY_BILL")
@Entity(name = "st_WayBill")
public class WayBill extends StandardEntity {
    private static final long serialVersionUID = -3365008887474479278L;

    @NotNull
    @Column(name = "REFERENCE", nullable = false, length = 100)
    private String reference;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREATOR_ID")
    private User creator;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SHIPPER_ID")
    private Customer shipper;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONSIGNEE_ID")
    private Customer consignee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTURE_PORT_ID")
    private SpacePort departurePort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESTINATION_PORT_ID")
    private SpacePort destinationPort;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CARRIER_ID")
    private Carrier carrier;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "wayBill")
    private List<WayBillItem> items;

    @NotNull
    @Column(name = "TOTAL_WEIGHT", nullable = false)
    private Double totalWeight;

    @NotNull
    @Column(name = "TOTAL_CHARGE", nullable = false)
    private Double totalCharge;

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<WayBillItem> getItems() {
        return items;
    }

    public void setItems(List<WayBillItem> items) {
        this.items = items;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public SpacePort getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(SpacePort destinationPort) {
        this.destinationPort = destinationPort;
    }

    public SpacePort getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(SpacePort departurePort) {
        this.departurePort = departurePort;
    }

    public Customer getConsignee() {
        return consignee;
    }

    public void setConsignee(Customer consignee) {
        this.consignee = consignee;
    }

    public Customer getShipper() {
        return shipper;
    }

    public void setShipper(Customer shipper) {
        this.shipper = shipper;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}