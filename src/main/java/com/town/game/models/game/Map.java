package com.town.game.models.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "city_Id")
    private City city;
    private Long width;
    private Long height;
    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    private List<Cell> cells = new ArrayList<>();

}
