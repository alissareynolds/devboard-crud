package com.project_management.devboard.controllers;

import com.project_management.devboard.models.Card;
import com.project_management.devboard.services.CardLogicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    CardLogicService cardLogicService;

    public CardController(CardLogicService cardLogicService) {
        this.cardLogicService = cardLogicService;
    }


    // get cards, get card by id, replace card, update card, delete card

    public List<Card> getCards() {
        return cardLogicService.getCards();
    }



}
