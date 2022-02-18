package com.augustorenan.springbootapi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.augustorenan.springbootapi.entities.Category;
import com.augustorenan.springbootapi.entities.Order;
import com.augustorenan.springbootapi.entities.OrderItem;
import com.augustorenan.springbootapi.entities.Payment;
import com.augustorenan.springbootapi.entities.Product;
import com.augustorenan.springbootapi.entities.User;
import com.augustorenan.springbootapi.entities.enums.OrderStatus;
import com.augustorenan.springbootapi.repositories.CategoryRepository;
import com.augustorenan.springbootapi.repositories.OrderItemRepository;
import com.augustorenan.springbootapi.repositories.OrderRepository;
import com.augustorenan.springbootapi.repositories.ProductRepository;
import com.augustorenan.springbootapi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Appliances");
		Category category3 = new Category(null, "clothes");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(category2);
		p2.getCategories().add(category1);
		p2.getCategories().add(category3);
		p3.getCategories().add(category3);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User user1 = new User(null, "Augusto", "Renan", "augusto@email.com", "augusto123");
		User user2 = new User(null, "Laura", "Moura", "laura@email.com", "laura123");

		Order order1 = new Order(null, Instant.parse("2022-02-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2022-02-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2022-02-22T15:21:22Z"), OrderStatus.DELIVERED, user1);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));

		OrderItem orderItem1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem orderItem2 = new OrderItem(order2, p3, 2, p4.getPrice());
		OrderItem orderItem3 = new OrderItem(order3, p3, 2, p1.getPrice());
		OrderItem orderItem4 = new OrderItem(order3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
		Payment pay1 = new Payment(null, Instant.parse("2022-02-20T21:53:07Z"), order1);
		order1.setPayment(pay1);
		
		orderRepository.save(order1);
	}

}
