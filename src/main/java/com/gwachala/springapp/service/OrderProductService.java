package com.gwachala.springapp.service;

import org.springframework.validation.annotation.Validated;

import com.gwachala.springapp.model.OrderProduct;


@Validated
public interface OrderProductService {

    OrderProduct create(OrderProduct orderProduct);

	Iterable<OrderProduct> getAllOrderProducts();

	
}