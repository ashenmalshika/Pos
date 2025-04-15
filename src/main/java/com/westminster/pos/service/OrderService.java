package com.westminster.pos.service;

import com.westminster.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.westminster.pos.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
