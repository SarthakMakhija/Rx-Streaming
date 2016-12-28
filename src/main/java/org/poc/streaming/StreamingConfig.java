package org.poc.streaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAsync
public class StreamingConfig {
    public static void main(String[] args) {
        SpringApplication.run(StreamingConfig.class, args);
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcAutoConfiguration(){
        return new WebMvcConfiguration();
    }

    public static class WebMvcConfiguration extends WebMvcConfigurerAdapter {
        @Override
        public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
            configurer.setDefaultTimeout(100000);
        }
    }
}