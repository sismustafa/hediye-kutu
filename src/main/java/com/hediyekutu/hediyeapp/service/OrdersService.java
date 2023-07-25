/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hediyekutu.hediyeapp.service;

import com.hediyekutu.hediyeapp.dto.ResponseCreatedOrder;
import com.hediyekutu.hediyeapp.model.Box;
import com.hediyekutu.hediyeapp.model.Orders;
import com.hediyekutu.hediyeapp.model.User;
import com.hediyekutu.hediyeapp.repository.OrdersRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final UserService userService;

    public ResponseCreatedOrder createOrder(Box box, Long userid) {
        Orders order = new Orders();
        User u = userService.getUser(userid);
        order.setUser(u);
        order.setBox(box);
        order = ordersRepository.save(order);
        return new ResponseCreatedOrder().builder()
                .id(order.getId())
                .message("Sn." + u.getName() + " Siparisiniz olusturuldu siparis kodu mailinze gonderilid " + u.getMail())
                .build();
    }

    public List<Orders> getAllOrderOfUser(Long id) {
        return ordersRepository.findByUserId(id);
    }
}
