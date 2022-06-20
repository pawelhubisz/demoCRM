package com.example.demo;

import com.example.demo.enums.ApplicationStatus;
import com.example.demo.service.UtilsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsController {

   private UtilsService utilsService;

    public UtilsController(UtilsService utilsService) {
        this.utilsService = utilsService;
    }

    @GetMapping("/status")
    public String status() {
        return utilsService.applicationStatus().name();
    }
}
