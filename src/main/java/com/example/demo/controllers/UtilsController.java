package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsController {
    @GetMapping("/status")
    public String applicationStatus() {
        return "UP";
    }
    @GetMapping("/setup")
    public String setUp() {
        //TODO dodaj zapisywanie danych na start, zeby nie klikac n razy w postmanie, a jedynie raz - tego endpointa (jak wczesniej robilismy w testach)
        return "UP";
    }

}
