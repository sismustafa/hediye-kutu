/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.service;

import com.hediyekutu.hediyeapp.dto.ProdAddDto;
import com.hediyekutu.hediyeapp.model.Products;
import com.hediyekutu.hediyeapp.model.Seller;
import com.hediyekutu.hediyeapp.repository.ProductsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
@AllArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final SellerService sellerService;

    public Products add(ProdAddDto dto) {
        Products p = new Products();
        p.setProductName(dto.getName());
        Seller s = sellerService.getSeller(dto.getSellerId());
        p.setSeller(s);
        return productsRepository.save(p);
    }

    public Products getProd(Long id) {
        return productsRepository.findById(id).get();
    }

    public List<Products> getAll() {
        return productsRepository.findAll();
    }
    

}
