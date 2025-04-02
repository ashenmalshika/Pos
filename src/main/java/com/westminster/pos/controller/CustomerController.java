package com.westminster.pos.controller;

import com.westminster.pos.dto.CustomerDTO;
import com.westminster.pos.dto.request.CustomerUpdateDTO;
import com.westminster.pos.service.CustomerService;
import com.westminster.pos.service.impl.CustomerServiceIMPL;
import com.westminster.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerServiceIMPL customerService;
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        //CustomerServiceIMPL customerService=new CustomerServiceIMPL();
        //customerService.saveCustomer(customerDTO);
        customerService.saveCustomer(customerDTO);
        return "saved successfully";
    }
    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message=customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(
            path="/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam int id){
        CustomerDTO customerDTO= customerService.getCustomerById(id);
        return customerDTO;
    }

  /*  @GetMapping(
            path="/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
        return allCustomers;
    }*/

    @GetMapping(
            path="/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"sucess",allCustomers), HttpStatus.OK
        );
        return response;
    }
    @DeleteMapping(
            path="delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value="id") int customerId){
        String deleted;
        deleted = customerService.deleteCustomer(customerId);
        return "Customer deleted successfully";
    }
}
