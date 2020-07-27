package com.gwachala.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gwachala.springapp.model.OrderProduct;
import com.gwachala.springapp.model.OrderProductKey;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductKey> {
}