package com.project_management.devboard.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok @Data adds getters, setters, hashCode, equals, toString()
@AllArgsConstructor // adds a constructor with all fields
@NoArgsConstructor // empty constructor
@Builder //  requires an all args constructor - helps you use the builder design pattern
@Entity
public class Card {

    @Id // specifies that it's an id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String acceptanceCriteria;
    private CardState state;
    private Integer storyPoints;
    // private User assigned;
    // private Card children;
    // private List<Card> children;
}
