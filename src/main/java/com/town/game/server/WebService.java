package com.town.game.server;

import com.town.game.dto.CityResponse;
import com.town.game.dto.MapCityRequest;

public interface WebService {

    CityResponse createCityWithMap(MapCityRequest mapCityRequest);
}
