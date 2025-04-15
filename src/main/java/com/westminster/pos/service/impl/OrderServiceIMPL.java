package com.westminster.pos.service.impl;

import com.westminster.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.westminster.pos.dto.queryInterface.OrderDetailsInterface;
import com.westminster.pos.dto.request.RequestOrderSaveDTO;
import com.westminster.pos.dto.response.ResponseOrderDetailsDTO;
import com.westminster.pos.entity.Order;
import com.westminster.pos.entity.OrderDetails;
import com.westminster.pos.repo.CustomerRepo;
import com.westminster.pos.repo.ItemRepo;
import com.westminster.pos.repo.OrderDetailRepo;
import com.westminster.pos.repo.OrderRepo;
import com.westminster.pos.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order=new Order(
                customerRepo.getById(requestOrderSaveDTO.getCustomerId()),
                requestOrderSaveDTO.getTotal(),
                requestOrderSaveDTO.getOrderDate()
        );
        orderRepo.save(order);
        if (orderRepo.existsById(order.getOrderId())){
                List<OrderDetails> orderDetails=modelMapper.map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());

                for (int i = 0; i < orderDetails.size(); i++) {
                    orderDetails.get(i).setOrders(order);
                    orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItem()));
                }

                if (orderDetails.size()>0){
                    orderDetailRepo.saveAll(orderDetails);
                }
            return "Saved";
        }
        return null;
    }

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailsInterface> orderDetailsDTOS=orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));
        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for (OrderDetailsInterface orderDetailsDTO : orderDetailsDTOS) {
            ResponseOrderDetailsDTO r=new ResponseOrderDetailsDTO(
                    orderDetailsDTO.getCustomerName(),
                    orderDetailsDTO.getCustomerAddress(),
                    orderDetailsDTO.getContactNumber(),
                    orderDetailsDTO.getDate(),
                    orderDetailsDTO.getTotal()
            );
            list.add(r);
        }

        PaginatedResponseOrderDetails paginatedResponseOrderDetails=new PaginatedResponseOrderDetails(
                list,orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetails;
    }
}
