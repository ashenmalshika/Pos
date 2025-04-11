package com.westminster.pos.dto.request;

import com.westminster.pos.entity.Customer;
import com.westminster.pos.entity.Item;
import com.westminster.pos.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customerId;
    private Date orderDate;
    private Double total;
    private List<RequestOrderDetailsSave> orderDetails;
}
