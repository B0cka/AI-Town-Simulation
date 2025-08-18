package com.town.game.dto;

import com.town.game.models.BuildingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingResponse {

    private Long x;
    private Long y;
    private BuildingType buildingType;
    private Long happiness;
    private Long coins;

}
