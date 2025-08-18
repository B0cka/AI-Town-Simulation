package com.town.game.models.game;

import com.town.game.models.BuildingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;
    private Long x;
    private Long y;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
