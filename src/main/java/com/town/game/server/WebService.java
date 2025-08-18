package com.town.game.server;

import com.town.game.dto.BuildingRequest;
import com.town.game.dto.BuildingResponse;

public interface WebService {

    BuildingResponse build(BuildingRequest buildingRequest);

}
