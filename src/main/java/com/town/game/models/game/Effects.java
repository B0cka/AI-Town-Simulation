package com.town.game.models.game;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Effects {

    private Long happiness;
    private Long coins;
}