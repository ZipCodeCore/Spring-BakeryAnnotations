package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/muffin")
public class MuffinController {
    private MuffinService service;
    
    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Iterable<Muffin>> list() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping(value = "/show/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id,@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping(value = "/destroy/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
