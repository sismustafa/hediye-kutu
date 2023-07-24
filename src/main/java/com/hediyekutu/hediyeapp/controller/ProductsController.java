/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.controller;

import com.hediyekutu.hediyeapp.dto.ProdAddDto;
import com.hediyekutu.hediyeapp.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("v1/prod/")
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody ProdAddDto dto) {
        return new ResponseEntity<>(productsService.add(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProd(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(productsService.getProd(id), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(productsService.getAll(), HttpStatus.OK);
    }


}
