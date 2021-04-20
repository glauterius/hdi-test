package br.com.teste.springtestehdi.controller;

import br.com.teste.springtestehdi.model.CorretorModel;
import br.com.teste.springtestehdi.service.CorretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hdi-test")
public class BrokerController {

    @Autowired
    private CorretorService service;

    @GetMapping(path = "/broker/{document}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCorretor(@PathVariable String document) {
        return new ResponseEntity<>( service.getCorretor(document), HttpStatus.OK);
    }

    @PutMapping(path = "/broker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putCorretor(@RequestBody CorretorModel corretor){
        return new ResponseEntity<>( service.putCorretor(corretor), HttpStatus.OK);
    }
}
