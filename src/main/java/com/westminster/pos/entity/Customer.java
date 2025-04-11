package com.westminster.pos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="customer_id", length =45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name", length =100, nullable = false)
    private String customerName;

    @Column(name="customer_Address", length =255)
    private String customerAddress;

    @JdbcTypeCode(SqlTypes.JSON)  // Hibernate 6+ JSON support
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name="nic")
    private String nic;

    @Column(name= "active_status" , columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Customer() {
    }

    public Customer(int customerId, boolean active, String nic, ArrayList contactNumber, String customerName, String customerAddress) {
        this.customerId = customerId;
        this.active = active;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}

