package org.poc.streaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Component
public class ProductsEmitter {

    @Autowired
    private ProductsService productsService;

    @Async
    //emitter.complete();  how to close this emitter ?
    public void emitProducts(SseEmitter emitter) {
        productsService.findAllProducts().subscribe(value -> {
                    try {
                        System.out.println(System.currentTimeMillis() + " " + value);
                        emitter.send(SseEmitter.event().data(value));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                emitter::completeWithError,
                () -> {
                    try {
                        emitter.send(SseEmitter.event().id("close"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
