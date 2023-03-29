package com.iphone14.controller;

import com.iphone14.payload.ClientRegDto;
import com.iphone14.security.ClientRegService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientReg")
public class ClientRegController {
    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    //http://localhost:8080/api/clientReg/create
    @PostMapping("/create")
    public ResponseEntity<String>createClientRegDto(@RequestBody ClientRegDto clientRegDto){
        ClientRegDto clientRegDto1 = clientRegService.createClientReg(clientRegDto);
        return new ResponseEntity<>("ClientReg has been created", HttpStatus.CREATED);
    }
}
