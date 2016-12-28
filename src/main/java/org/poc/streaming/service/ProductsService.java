package org.poc.streaming.service;

import org.poc.streaming.model.Product;
import org.poc.streaming.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;

import java.util.concurrent.TimeUnit;

import static rx.Observable.from;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Observable<Product> findAllProducts() {
        return from( productsRepository.findAllProducts() ).map( p -> performHeavyComputation(p) );
    }

    private Product performHeavyComputation(Product p ){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return p;
    }
}