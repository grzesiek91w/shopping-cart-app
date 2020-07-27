package com.gwachala.springapp.exchange;

import java.util.ArrayList;
import java.util.List;

import com.gwachala.springapp.model.Order;
import com.gwachala.springapp.model.Product;

public class OrderProductDto {

    private Product product;
    private Integer quantity;
    private Order order;
    //private String firstName;
   // private String lastName;
    
    private List<OrderProductDto> orderProductDto =new ArrayList<>();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderProductDto> getOrderProductDto() {
		return orderProductDto;
	}

	public void setOrderProductDto(List<OrderProductDto> orderProductDto) {
		this.orderProductDto = orderProductDto;
	}

	@Override
	public String toString() {
		return "OrderProductDto [product=" + product + ", quantity=" + quantity + ", order=" + order
				+ ", orderProductDto=" + orderProductDto + "]";
	}
    
 

    
    
    

    
    
}
