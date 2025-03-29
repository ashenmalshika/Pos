package com.westminster.pos.service;

import com.westminster.pos.dto.CustomerDTO;
import com.westminster.pos.dto.request.CustomerUpdateDTO;
import com.westminster.pos.entity.Customer;

import java.util.List;

public interface CustomerService {
    String deleteCustomer(int customerId);

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);


    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();
}
