package com.westminster.pos.dto.request;

import com.westminster.pos.entity.Item;
import com.westminster.pos.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String itemName;
    private Double qty;
    private Double amount;
    private int item;
    private int orders;

}
