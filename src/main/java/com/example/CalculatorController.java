package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private Calculator calc;


    @ResponseBody
    @RequestMapping("/sum/{a}/{b}")
    public Result sum(@PathVariable int a, @PathVariable int b) {
        return addLinks(a, b, new Result(calc.sum(a, b), a + "+" + b));
    }

    @ResponseBody
    @RequestMapping("/sub/{a}/{b}")
    public Result sub(@PathVariable int a, @PathVariable int b) {
        return addLinks(a, b, new Result(calc.sub(a, b), a + "-" + b));
    }

    @ResponseBody
    @RequestMapping("/div/{a}/{b}")
    public Result div(@PathVariable int a, @PathVariable int b) {
        return addLinks(a, b, new Result(calc.div(a, b), a + "*" + b));
    }

    @ResponseBody
    @RequestMapping("/mul/{a}/{b}")
    public Result mul(@PathVariable int a, @PathVariable int b) {
        return addLinks(a, b, new Result(calc.mul(a, b), a + "*" + b));
    }

    private Result addLinks(int a, int b, Result result) {
        result.add(linkTo(methodOn(getClass()).sum(a, b)).withRel("sum"));
        result.add(linkTo(methodOn(getClass()).sub(a, b)).withRel("sub"));
        result.add(linkTo(methodOn(getClass()).mul(a, b)).withRel("mul"));
        result.add(linkTo(methodOn(getClass()).div(a, b)).withRel("div"));
        return result;
    }
}
