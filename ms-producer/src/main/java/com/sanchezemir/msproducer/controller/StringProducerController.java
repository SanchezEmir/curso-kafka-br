package com.sanchezemir.msproducer.controller;

import com.sanchezemir.msproducer.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kafka/producer")
public class StringProducerController {

    private final StringProducerService stringProducerService;

    @PostMapping
    public ResponseEntity<Void> sendMessage( @RequestBody String message ){
        stringProducerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
