package com.westminster.pos.repo;


import com.westminster.pos.entity.Order;
import com.westminster.pos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}
