package com.newproject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class Api {

@GetMapping
    public String deneme (){
        return "Hello World";
    }

}
