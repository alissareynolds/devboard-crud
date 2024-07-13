package com.project_management.devboard;

import com.project_management.devboard.models.Card;

public class Sandbox {
    public static void main(String[] args) {
        Card card = new Card();
        card.setDescription("hello");

        Card card2 = new Card();
        card2.setDescription("hello");

        Card card3 = Card.builder().acceptanceCriteria("Hello").description("hello 2").name("Task 234").id(56).build();
        // ^ this is called the Builder Design Patten - uses the @Builder lombok annotation in the Card class
        /*
        can also organize the builder like this:
         Card card3 = Card.builder()
            .acceptanceCriteria("Hello")
            .description("hello 2")
            .name("Task 234")
            .id(56)
            .build();
         */

        System.out.println(card.equals(card2)); // you get true because they have the same values
    }
}
