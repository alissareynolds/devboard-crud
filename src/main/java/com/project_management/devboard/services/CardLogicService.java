package com.project_management.devboard.services;

import com.project_management.devboard.dao.CardDAO;
import com.project_management.devboard.exceptions.CardNotFoundException;
import com.project_management.devboard.models.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardLogicService {

    CardDAO cardDAO;

    public CardLogicService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public List<Card> getCards() {
        return cardDAO.getCards();
    }

    public Card create(Card input) {
        return cardDAO.create(input);
    }

    public Card getCardById(Integer id) {
        Optional<Card> optional = cardDAO.getCardById(id);
        if (optional.isEmpty()) {
            throw new CardNotFoundException("A card with id: " + id + " was not found.");
        }
        return optional.get();
    }
    // this stores all the logic for the cards

}
