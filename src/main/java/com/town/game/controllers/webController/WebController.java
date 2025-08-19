package com.town.game.controllers.webController;

import com.town.game.dto.BuildingRequest;
import com.town.game.dto.BuildingResponse;
import com.town.game.dto.CityResponse;
import com.town.game.dto.MapCityRequest;
import com.town.game.server.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final WebService webService;

    @PostMapping("/create/map-city")
    public CityResponse createMapAndCity(@RequestBody MapCityRequest request) {
        log.info("POST Create city and map with params: name={}, width={}, height={}",
                request.getName(), request.getWeight(), request.getHeight());

        return webService.createCityWithMap(request);
    }

//    @PostMapping("/build")
//    public BuildingResponse build(@RequestBody BuildingRequest buildingRequest) {
//        log.info("POST Create building with param={}", buildingRequest);
//        return webService.build(buildingRequest);
//    }
}