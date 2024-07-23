package com.project_management.devboard.controllers;

import com.project_management.devboard.exceptions.CardNotFoundException;
import com.project_management.devboard.models.Card;
import com.project_management.devboard.services.CardLogicService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private CardLogicService cardLogicService;

    public CardController(CardLogicService cardLogicService) {
        this.cardLogicService = cardLogicService;
    }

    @PostMapping
    public Card createCard(@RequestBody Card input) {
        return cardLogicService.create(input);
    }

    @GetMapping
    public List<Card> getCards() {
        return cardLogicService.getCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Integer id) {
        try {
            return cardLogicService.getCardById(id);
        } catch (CardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}
