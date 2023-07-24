/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.service;

import com.hediyekutu.hediyeapp.dto.UserDto;
import com.hediyekutu.hediyeapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hediyekutu.hediyeapp.model.User;

@Service
@AllArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto add(UserDto dto) {
        User u = userRepository.save(modelMapper.map(dto, User.class));
        return modelMapper.map(u, UserDto.class);
    }
    
    
    public User getUser(Long id){
        return userRepository.findById(id).get();
    }
}
