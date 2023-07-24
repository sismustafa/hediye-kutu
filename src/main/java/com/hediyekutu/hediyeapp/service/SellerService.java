/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.service;

import com.hediyekutu.hediyeapp.dto.SellerDto;
import com.hediyekutu.hediyeapp.model.Seller;
import com.hediyekutu.hediyeapp.repository.SellerRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class SellerService {

    private SellerRepository sellerRepository;
    private ModelMapper modelMapper;

    public Seller add(SellerDto dto) {
        Seller s = modelMapper.map(dto, Seller.class);
        return sellerRepository.save(s);
    }

    public Seller getSeller(Long id) {

        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isPresent()) {
            return seller.get();
        } else {
            return null;
        }

    }

}
