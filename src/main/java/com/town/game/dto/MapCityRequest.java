package com.town.game.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MapCityRequest {

    @NotNull
    private String name;
    @NotNull @Min(10) @Max(100)
    private Long height;
    @NotNull @Min(10) @Max(100)
    private Long weight;

}
