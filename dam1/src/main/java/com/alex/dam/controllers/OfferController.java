package com.alex.dam.controllers;

import com.alex.dam.model.OrderType;
import com.alex.dam.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/useroffers")
@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @RequestMapping({"/selloffers"})
    public String listSellOffers(Model model){

        model.addAttribute("sellenergyoffers", offerService.findAllByOrderType(OrderType.SELL));  //offerService.findAllByOrderType(OrderType.SELL));
        return "useroffers/selloffers";
    }

    @RequestMapping({"/buyoffers"})
    public String listBuyOffers(Model model){

        model.addAttribute("buyenergyoffers", offerService.findAllByOrderType(OrderType.BUY));  //offerService.findAllByOrderType(OrderType.SELL));
        return "useroffers/buyoffers";
    }

}
