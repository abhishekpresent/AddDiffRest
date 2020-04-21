package com.calculator.demo.service;

import com.calculator.demo.model.Response;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {
    @Override
    public Response add (String a , String b){
        Response responseObj =  new Response(null);
        if(isNumeric(a) && isNumeric(b)) {
            double sum=Double.parseDouble(a) + Double.parseDouble(b);
            responseObj.setResult(getResultAdd(sum));
        }else{
            responseObj.setResult("Not a number");
        }
        return responseObj;
    }

    @Override
    public Response diff (String a , String b){
        Response responseObj =  new Response(null);
        if(isNumeric(a) && isNumeric(b)) {
            double diff=Double.parseDouble(a) - Double.parseDouble(b);
            responseObj.setResult(getResultDiff(diff));
        }else{
            responseObj.setResult("Not a number");
        }
        return responseObj;
    }

    private boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private String getResultAdd(double sum){
        System.out.println("sum = " + sum +" int sum=" + (int)sum);
        if ((sum == Math.floor(sum)) && !Double.isInfinite(sum) && sum <= (int)sum) {
            return String.valueOf((int)sum);
        }
        return String.valueOf(sum);
    }

    private String getResultDiff(double sum){
        System.out.println("sum = " + sum +" int sum  =" + (int)sum);
        if ((sum == Math.floor(sum)) && !Double.isInfinite(sum) && sum >= (int)sum) {
            return String.valueOf((int)sum);
        }
        return String.valueOf(sum);
    }


}
