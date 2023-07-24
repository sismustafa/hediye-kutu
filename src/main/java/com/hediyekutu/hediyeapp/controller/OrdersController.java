/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.controller;

import com.hediyekutu.hediyeapp.dto.BuyItems;
import com.hediyekutu.hediyeapp.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping("u/{id}/all")
    public ResponseEntity<?> allOrderOfUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(ordersService.getAllOrderOfUser(id), HttpStatus.OK);
    }

}
