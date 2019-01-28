package com.jluzh.order.repository;


import com.jluzh.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
