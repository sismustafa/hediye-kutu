/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.service;

import com.hediyekutu.hediyeapp.dto.BuyItems;
import com.hediyekutu.hediyeapp.dto.ResponseCreatedOrder;
import com.hediyekutu.hediyeapp.repository.BoxRepository;
import com.hediyekutu.hediyeapp.model.Box;

import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoxService {

    private final BoxRepository boxRepository;
    private final ProductsService productsService;
    private final OrdersService ordersService;

    public ResponseCreatedOrder addItem(BuyItems dto) {
        Box b = new Box();
        ResponseCreatedOrder temp = null;
        b.setCapacity(dto.getCapacity());
        String sepetBilgi = dto.getProductId().stream()
                .map(id -> productsService.getProd(id))
                .map((p) -> "id:" + p.getId() + " urun adi: " + p.getProductName() + " satici: " + p.getSeller().getName())
                .collect(Collectors.joining());

        b.setAllProd(sepetBilgi);
        Box addendBox = boxRepository.save(b);
        System.out.println("kutunun id: " + addendBox.getId());
        if (addendBox.getId() > 0) {
            temp = ordersService.createOrder(addendBox, dto.getUserId());
        }
        return temp;
    }

}
