package com.pedrotavares.springbootordermanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.pedrotavares.springbootordermanagement.model.Product;
import com.pedrotavares.springbootordermanagement.model.TheOrder;
import com.pedrotavares.springbootordermanagement.service.OrderService;
import com.pedrotavares.springbootordermanagement.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootOrderManagementApplicationTests {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	Product product1, product2;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Before
	public void createProductsAndOrder( ) {
		product1 = new Product("Product1 Name", "Product1 Description", 1);
		product2 = new Product("Product2 Name", "Product2 Description", 2);
	}

	@Test
	@Order(1)
	public void contextLoads() {}
	
	@Test
	@Order(2)
	public void testSave() {
		System.out.println("\ntestSaveProducts");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Update Order
		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		
		TheOrder order = new TheOrder();
		order.setProducts(products);
		em.getTransaction().begin();
		order.setBuyerEmail("someone@email.com");
		orderService.saveOrder(order);
		em.getTransaction().commit();
		
		// Now update OrderIds
		em.getTransaction().begin();
		product1.setOrderId(order.getOrderID());
		product2.setOrderId(order.getOrderID());
		product1 = productService.save(product1);
		product2 = productService.save(product2);
		em.getTransaction().commit();

		products = productService.getProducts();
		assertThat(products.size(), is(2));
		//assertThat(products, hasItems(product1, product2));	 
	}
	
	
	private Date yesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	private Date tomorrow() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, +1);
	    return cal.getTime();
	}
	
	@Test
	@Order(3)
	public void testFindOrdersByDate() {
		System.out.println("\ntestFindOrdersByDate");
		
		List<TheOrder> ordersByDate = orderService.getOrders(yesterday(), tomorrow());
		System.out.println(ordersByDate);
		assertThat(ordersByDate.size(), is(1));
	}
}
