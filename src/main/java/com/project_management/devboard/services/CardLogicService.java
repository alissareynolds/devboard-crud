package com.project_management.devboard.services;

import com.project_management.devboard.dao.CardDAO;
import com.project_management.devboard.models.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardLogicService {

    CardDAO cardDAO;

    public CardLogicService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public List<Card> getCards() {
        return cardDAO.getCards();
    }
    // this stores all the logic for the cards

}
