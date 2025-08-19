package com.town.game.models.game;

import com.town.game.models.CellsType;
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
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "map_id")
    private GameMap gameMap;
    private Long x;
    private Long y;
    @Enumerated(EnumType.STRING)
    private CellsType type;

}
