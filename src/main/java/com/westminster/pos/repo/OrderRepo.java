package com.westminster.pos.repo;


import com.westminster.pos.dto.queryInterface.OrderDetailsInterface;
import com.westminster.pos.dto.response.ResponseOrderDetailsDTO;
import com.westminster.pos.entity.Item;
import com.westminster.pos.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT c.customer_name as customerName,c.customer_Address as customerAddress,c.contact_numbers as contactNumber,o.order_date as date,o.total as total from customer c,orders o where c.active_status= ?1 and c.customer_id = o.customer_id ",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "SELECT count(*) from customer c,orders o where c.active_status= ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
//