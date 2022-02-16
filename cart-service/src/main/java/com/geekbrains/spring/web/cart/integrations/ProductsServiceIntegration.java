package com.geekbrains.spring.web.cart.integrations;

import com.geekbrains.spring.web.api.core.ProductDto;
import com.geekbrains.spring.web.api.responce.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductsServiceIntegration {
    private final RestTemplate restTemplate;

    @Value("${integrations.core-service.url}")
    private String productServiceUrl;


    public Response findById(Long id) {
        log.info("Посылаем запрос в продуктовый сервис");
        try {

            Response productDto = restTemplate.getForObject(
                    productServiceUrl + "/api/v1/products/with_exception/" + id, Response.class
            );
            return productDto;
        } catch (HttpServerErrorException e ){
            Response response = new Response();
            response.setCode(400);
            response.setSuccess(false);
            response.setProductDto(null);
            response.setMessage("Core сервис не работает");
            return response;
        }
    }
}
