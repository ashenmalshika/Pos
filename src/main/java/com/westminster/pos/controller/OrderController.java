package com.westminster.pos.controller;

import com.westminster.pos.dto.request.ItemSaveRequestDTO;
import com.westminster.pos.dto.request.RequestOrderSaveDTO;
import com.westminster.pos.service.OrderService;
import com.westminster.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id=orderService.addOrder(requestOrderSaveDTO);
        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"sucessfully saved.",id), HttpStatus.CREATED
        );
        return response;
    }
}
