package com.town.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityResponse {
    private Long cityId;
    private String cityName;
    private Long mapId;
    private Long width;
    private Long height;
    private String message;
}