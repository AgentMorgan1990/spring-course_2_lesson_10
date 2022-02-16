package com.geekbrains.spring.web.api.responce;


import com.geekbrains.spring.web.api.core.ProductDto;

public class Response {

    public Response(int code, boolean success, String message, ProductDto productDto) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.productDto = productDto;
    }

    public Response() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    int code;

    boolean success;

    String message;

    ProductDto productDto;

}
