package com.westminster.pos.dto;

import java.util.ArrayList;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;
    private String nic;
    private boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, boolean active, String nic, ArrayList contactNumber, String customerName, String customerAddress) {
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