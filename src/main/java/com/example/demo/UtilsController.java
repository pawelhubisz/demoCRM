package com.example.demo;

import com.example.demo.enums.ApplicationStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsController {

    @GetMapping("/status")
    public String status() {
        return ApplicationStatus.UP.name();
    }
}
