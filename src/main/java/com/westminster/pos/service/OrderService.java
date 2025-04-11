package com.westminster.pos.service;

import com.westminster.pos.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
