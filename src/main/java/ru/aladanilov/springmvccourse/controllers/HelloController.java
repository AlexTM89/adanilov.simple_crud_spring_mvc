package ru.aladanilov.springmvccourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String goHello(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {
        model.addAttribute("message", name + "\n" + surname);
        return "hello/hello";
    }
    @GetMapping("/goodbye")
    public String goGoodBye() {
        return "hello/goodbye";
    }
}
