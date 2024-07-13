package com.project_management.devboard.dao;

import com.project_management.devboard.models.Card;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

// it is going to try and instantiate itself by calling the constructor
@Component // we want this class to automatically load up without having to call a constructor to use in other classes
public class JdbcCardDao implements CardDAO {

    JdbcTemplate jdbcTemplate;

    public JdbcCardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Card create(Card input) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public List<Card> getCards() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Optional<Card> getCardById(Integer id) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Card update(Card card) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void delete(Card card) {
        throw new RuntimeException("Not Implemented");
    }
}
