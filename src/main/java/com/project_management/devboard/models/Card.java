package com.project_management.devboard.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // Lombok @Data adds getters, setters, hashCode, equals, toString()
@AllArgsConstructor // adds a constructor with all fields
@NoArgsConstructor // empty constructor
@Builder //  requires an all args constructor - helps you use the builder design pattern
@Entity(name = "cards") // this changes the table name to cards
public class Card {

    @Id // specifies that it's an id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private CardState state;

    @Column(name = "story_points")
    private Integer storyPoints;
    // private User assigned;
    private Card parent;
    private List<Card> children;
}
