/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.controller;

import com.hediyekutu.hediyeapp.dto.UserDto;
import com.hediyekutu.hediyeapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody UserDto dto) {
        return new ResponseEntity<>(userService.add(dto), HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

}
