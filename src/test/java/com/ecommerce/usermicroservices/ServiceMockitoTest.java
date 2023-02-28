package com.ecommerce.usermicroservices;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import com.ecommerce.usermicroservices.entity.Cart;
import com.ecommerce.usermicroservices.repository.CartRepository;
import com.ecommerce.usermicroservices.service.CartService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	CartRepository cartRepository;
	
	 @InjectMocks
	CartService cartService;
 
	    @Test
	    @Order(1)
	    public void test_addCart() {
	        Cart cart = new Cart(1,1,"oppo","gfh",1,234,4.0,234);
	        when(cartRepository.save(cart)).thenReturn(cart);
	        assertEquals(cart,cartService.createCart(cart));
	    }
	    
	 
	    @Test
	    @Order(2)
	    public void test_getAllCart() {

	        List<Cart> allCatalog = new ArrayList<Cart>();
	        allCatalog.add(new Cart(1,1,"oppo","gfh",1,234,4.0,234));
	        when(cartRepository.findAll()).thenReturn(allCatalog);
	        assertEquals(1,cartService.getAllCart().size());

	    }
	    
	    
	    @Test
	    @Order(3)
	    public void test_updateCart() {
	    	Cart cart = (new Cart(1,1,"oppo","gfh",1,234,4.0,234));
	    	cart.setProduct_name("mobile");
	    	cartRepository.save(cart);
	        assertEquals("mobile", cart.getProduct_name());
	    }
	    
	    
	    @Test
	    @Order(4)
	    public void test_deleteCart() {
	    	Cart cart = new Cart(1,1,"oppo","gfh",1,234,4.0,234);
	    	   cartRepository.deleteById(cart.getId());
	    	   Cart deletedCart =  cartRepository.getById(1);
	            assertThat(deletedCart).isNull();
	    }
	    
	    
	    
	    
	    
	    
	    

}
