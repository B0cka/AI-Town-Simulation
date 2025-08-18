package com.town.game.models.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long userCount;
    private Long happiness;
    private Long coins;
    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
    private Map map;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Building> buildings = new ArrayList<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();

}
