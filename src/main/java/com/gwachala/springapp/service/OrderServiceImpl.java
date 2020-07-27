package com.gwachala.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwachala.springapp.model.Order;

import com.gwachala.springapp.repository.OrderRepository;

import java.time.LocalDate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        

        return this.orderRepository.save(order);
    }
    
    @Override
    public Order  getOrder(long id) {
        return orderRepository
          .findOne(id);
    }
    
    @Override
	public void delete(long id) {
		orderRepository.delete(id);
		
	}

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
