/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.controller;

import com.hediyekutu.hediyeapp.dto.BuyItems;
import com.hediyekutu.hediyeapp.service.BoxService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/box")
@AllArgsConstructor
public class BoxController {

    private final BoxService boxService;

    @PostMapping("addItem")
    public ResponseEntity<?> addItem(@RequestBody BuyItems dto) {
        return new ResponseEntity<>(boxService.addItem(dto), HttpStatus.OK);
    }

}
