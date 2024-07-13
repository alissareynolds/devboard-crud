package com.project_management.devboard.dao;

import com.project_management.devboard.models.Card;

import java.util.List;
import java.util.Optional;

public interface CardDAO {

    Card create(Card input);
    List<Card> getCards();
    Optional<Card> getCardById(Integer id); // optional is a wrapper - if it doesn't exist, when you call isEmpty it returns true
    Card update(Card card);
    void delete(Card card);

}
