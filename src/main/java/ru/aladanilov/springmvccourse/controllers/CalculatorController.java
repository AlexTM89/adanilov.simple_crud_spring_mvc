package ru.aladanilov.springmvccourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first/calculator")
public class CalculatorController {
    @GetMapping
    public String getCalcResult(@RequestParam("a") int a,
                                @RequestParam("b") int b,
                                @RequestParam("op") String operation,
                                Model model) {
        model.addAttribute("firstParam", a);
        model.addAttribute("secondParam", b);

        Operations operations = Operations.valueOf(operation);
        System.out.println(operations.getOp());

        double result = 0;
        switch (operations) {
            case plus:
                result = a + b;
                break;
            case minus:
                result = a - b;
                break;
            case division:
                try {
                    result = (double) a / b;
                } catch (ArithmeticException e) {
                    model.addAttribute("result", e.getMessage());
                }
                break;

            case multiplication:
                result = a * b;
                break;
            default:
                model.addAttribute("result", "invalid operation = no result");
                result = -111111111;
        }
        if (result > -111111111) {
            model.addAttribute("result", result);
        }
        return "calc/result";
    }
}

enum Operations {
    plus ("plus"),
    minus ("minus"),
    multiplication ("multiplication"),
    division ("division");

    public String getOp() {
        return op;
    }

    public final String op;

    Operations(String operation) {
        this.op = operation;
    }


}