package com.town.game.models.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "city_Id")
    private City city;
    private String prompt;

    @ElementCollection
    @CollectionTable(name = "event_effects", joinColumns = @JoinColumn(name = "event_id"))
    @MapKeyColumn(name = "choice_key")
    private Map<String, Effects> orders = new HashMap<>();

}
