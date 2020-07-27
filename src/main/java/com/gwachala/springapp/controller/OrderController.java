package com.gwachala.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.gwachala.springapp.exchange.OrderProductDto;
import com.gwachala.springapp.model.Order;
import com.gwachala.springapp.model.OrderProduct;

import com.gwachala.springapp.model.OrderStatus;

import com.gwachala.springapp.service.OrderProductService;
import com.gwachala.springapp.service.OrderService;
import com.gwachala.springapp.service.ProductService;

import javax.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    ProductService productService;
	@Autowired
    OrderService orderService;
	@Autowired
    OrderProductService orderProductService;

	
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> getOrder(@PathVariable long id) {
		Order order = orderService.getOrder(id);

		if (order != null) {
			return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
		Order currentOrder = orderService.getOrder(id);
		
		if (currentOrder.getId() == id) {
			orderService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}

    
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody OrderProductDto orderProductForm, @PathVariable Long id) {
	  
    	Order currentOrder = orderService.getOrder(id);
    	if (currentOrder == null) {
    		return new ResponseEntity<Order>(HttpStatus.UNAUTHORIZED);
    		
    	}
	       OrderProductDto productDto = new OrderProductDto();
        
	 
        productDto.setProduct(orderProductForm.getProduct());
        productDto.setQuantity(orderProductForm.getQuantity());
        productDto.setOrder(orderProductForm.getOrder());
        
     
        orderProductForm.setOrderProductDto(Collections.singletonList(productDto));
	    
        List<OrderProductDto> orderProductDtoForm = orderProductForm.getOrderProductDto();
        
      
        currentOrder = orderProductForm.getOrder();
        currentOrder.setId(id);
        currentOrder.setStatus(OrderStatus.PAID.name());
 
       currentOrder = orderService.create(currentOrder);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto orderProductdtos : orderProductDtoForm) {
            orderProducts.add(orderProductService.create(new OrderProduct(currentOrder, productService.getProduct(orderProductdtos
              .getProduct()
              .getId()), 
              orderProductdtos.getQuantity())));
        }
       
        currentOrder.setOrderProducts(orderProducts);

        orderService.update(currentOrder);

        String servletUri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(currentOrder.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("LocationUpdate", servletUri);

        return new ResponseEntity<>(currentOrder, headers, HttpStatus.CREATED);
    }

    
    
    
    
	 @PostMapping
	    public ResponseEntity<Order> createOrder(@RequestBody OrderProductDto orderProductForm) {
		  
		 
		 OrderProductDto orderProductDto = new OrderProductDto();
	        
		 
	        orderProductDto.setProduct(orderProductForm.getProduct());
	        orderProductDto.setQuantity(orderProductForm.getQuantity());
	        orderProductDto.setOrder(orderProductForm.getOrder());
	        
	     
	        orderProductForm.setOrderProductDto(Collections.singletonList(orderProductDto));
		    
	        List<OrderProductDto> orderProductDtoForms = orderProductForm.getOrderProductDto();
	        
	    
	        Order order = orderProductForm.getOrder();
	        order.setStatus(OrderStatus.PAID.name());
	        order = orderService.create(order);

	        List<OrderProduct> orderProducts = new ArrayList<>();
	        for (OrderProductDto orderProductDtos : orderProductDtoForms) {
	            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(orderProductDtos
	              .getProduct()
	              .getId()), 
	            orderProductDtos.getQuantity())));
	        }

	        order.setOrderProducts(orderProducts);

	        orderService.update(order);

	        String servletUri = ServletUriComponentsBuilder
	          .fromCurrentServletMapping()
	          .path("/orders/{id}")
	          .buildAndExpand(order.getId())
	          .toString();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Location", servletUri);

	        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	    }

	
	    
    

}
