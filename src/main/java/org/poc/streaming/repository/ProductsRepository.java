package org.poc.streaming.repository;

import org.poc.streaming.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Repository
public class ProductsRepository {

    private List<Product> products;

    @PostConstruct
    public void cacheAllProducts(){
        products = new ArrayList<>();
        products = IntStream.rangeClosed(1, 100).mapToObj( i -> new Product(i, randomAlphabetic(10)) ).collect(toList());
    }

    public List<Product> findAllProducts(){
        return products;
    }
}