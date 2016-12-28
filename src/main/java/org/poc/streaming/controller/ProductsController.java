package org.poc.streaming.controller;

import org.poc.streaming.service.ProductsEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@RestController
public class ProductsController {

    @Autowired
    private ProductsEmitter productsEmitter;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public SseEmitter findAllProducts() {
        SseEmitter emitter = new SseEmitter();
        productsEmitter.emitProducts(emitter);

        return emitter;
    }
}