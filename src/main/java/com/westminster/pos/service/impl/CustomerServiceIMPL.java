package com.westminster.pos.service.impl;

import com.westminster.pos.dto.CustomerDTO;
import com.westminster.pos.dto.request.CustomerUpdateDTO;
import com.westminster.pos.entity.Customer;
import com.westminster.pos.exception.NotFoundException;
import com.westminster.pos.repo.CustomerRepo;
import com.westminster.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer deleted";
        }else {
            throw new RuntimeException("No such customer found");
        }

    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.isActive(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerId(customerUpdateDTO.getCustomerId());
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName()+" Successfully updated";
        }else{
            throw new RuntimeException("data not found.");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.getReferenceById(id);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.isActive(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.getCustomerName()
            );
            return customerDTO;
        }else{
            throw new RuntimeException("No Customer with id .");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();

        if (getAllCustomers.size() > 0) {
            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.isActive(),
                        customer.getCustomerAddress(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.getCustomerName()
                );
                customerDTOList.add(customerDTO);
            }

            return customerDTOList;
        } else {
            throw  new NotFoundException("No Customer Found.");
        }
    }
}
