package com.calculator.demo.controller;


import com.calculator.demo.model.Numbers;
import com.calculator.demo.model.Response;
import com.calculator.demo.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class CalculatorController {
    @Autowired
    private ICalculator calculator ;

    @PostMapping(value ="/add" , consumes = "application/json", produces = "application/json")
    public Response addNumbers(@Valid @RequestBody Numbers numbers){
    return calculator.add(numbers.getA(),numbers.getB());
    }

    @PostMapping(value ="/diff" , consumes = "application/json", produces = "application/json")
    public Response diffNumbers(@Valid @RequestBody Numbers numbers){
        return calculator.diff(numbers.getA(),numbers.getB());
    }
}
