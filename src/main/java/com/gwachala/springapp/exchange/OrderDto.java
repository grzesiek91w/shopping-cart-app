package com.gwachala.springapp.exchange;

import java.util.ArrayList;
import java.util.List;

import com.gwachala.springapp.model.Order;
import com.gwachala.springapp.model.OrderProduct;

public class OrderDto {
	
	private Order order;
	
	 private List<OrderProduct> orderProducts = new ArrayList<>();

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
	public String toString() {
		return "OrderDto [order=" + order + ", orderProducts=" + orderProducts + "]";
	}
	
	
	
	

}
