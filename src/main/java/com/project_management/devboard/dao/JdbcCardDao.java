package com.project_management.devboard.dao;

import com.project_management.devboard.models.Card;
import com.project_management.devboard.models.CardState;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
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
        String sqlQuery = "INSERT INTO cards (name, description, state, story_points, acceptance_criteria) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        int id = jdbcTemplate.queryForObject(sqlQuery, int.class, input.getName(), input.getDescription(), input.getState(), input.getStoryPoints(), input.getAcceptanceCriteria());
        return getCardById(id).get();
    }

    @Override
    public Optional<Card> getCardById(Integer id) {
        String sqlQuery = "SELECT * FROM cards WHERE id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlQuery, id);
        if(rowSet.next()) {
            return Optional.of(mapRowToCard(rowSet));
        }
        return Optional.empty();
    }

    @Override
    public List<Card> getCards() {
        String sqlQuery = "SELECT * FROM cards";
        List<Card> results = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlQuery);
        while(rowSet.next()) {
            results.add(mapRowToCard(rowSet));
        }
        return results;
    }

    private Card mapRowToCard(SqlRowSet rowSet) {
        return Card.builder()
                .id(rowSet.getInt("id"))
                .state(CardState.valueOf(rowSet.getString("state")))
                .storyPoints(rowSet.getInt("story_points"))
                .acceptanceCriteria(rowSet.getString("acceptance_criteria"))
                .description(rowSet.getString("description"))
                .name(rowSet.getString("name"))
                .build();
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
