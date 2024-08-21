package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku(UUID.randomUUID().toString());
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product saveObject = productRepository.save(product);

        // display product info
        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());
    }


    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("update product 1");
        product.setDescription("update product 1 desc");

        //save update entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }


    @Test
    void saveAllMethod() {
        // create product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku(UUID.randomUUID().toString());
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");


        // create product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku(UUID.randomUUID().toString());
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");


        productRepository.saveAll(List.of(product2, product3));
    }


    @Test
    void findAllMethod() {

        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }


    @Test
    void deleteByIdMethod() {
        Long id = 13L;
        productRepository.deleteById(id);
    }


    @Test
    void deleteMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        Product product = productRepository.findById(20L).get();
        Product product2 = productRepository.findById(21L).get();

        productRepository.deleteAll(List.of(product, product2));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }


}