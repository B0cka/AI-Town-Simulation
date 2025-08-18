package com.town.game.dto;

import com.town.game.models.BuildingType;
import lombok.Data;

@Data
public class BuildingRequest {

    private Long x;
    private Long y;
    private BuildingType buildingType;

}
