package com.calculator.demo.model;

import org.hibernate.validator.constraints.NotBlank;

public class Numbers {
    @NotBlank(message = "Name is mandatory")
    private String a;
    @NotBlank(message = "Name is mandatory")
    private String b;

    public Numbers(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "numbers{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
