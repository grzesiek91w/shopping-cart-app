package com.gwachala.springapp.service;

import org.springframework.validation.annotation.Validated;

import com.gwachala.springapp.model.Order;

import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Order create(Order order);

    void update(Order order);

	Order getOrder(long id);

	void delete(long id);
}