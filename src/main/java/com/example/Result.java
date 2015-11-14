package com.example;

import org.springframework.hateoas.ResourceSupport;

public class Result extends ResourceSupport {

    private String operation;
    private int result;

    public Result(int result, String operation) {
        this.result = result;
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public int getResult() {
        return result;
    }
}
