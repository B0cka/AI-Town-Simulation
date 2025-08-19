package com.town.game.server;

import com.town.game.dto.BuildingRequest;
import com.town.game.dto.BuildingResponse;
import com.town.game.dto.CityResponse;
import com.town.game.dto.MapCityRequest;
import com.town.game.models.game.City;
import com.town.game.models.game.GameMap;
import com.town.game.repository.CityRepository;
import com.town.game.repository.GameMapRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceImpl implements WebService{

    private CityRepository cityRepository;
    private GameMapRepository gameMapRepository;

    @Override
    @Transactional
    public CityResponse createCityWithMap(MapCityRequest request) {
        log.info("Создание города");
        City city = City.builder()
                .name(request.getName())
                .happiness(50L)
                .coins(100L)
                .build();
        city = cityRepository.save(city);
        log.info("Создание карты");
        GameMap map = GameMap.builder()
                .width(request.getWeight())
                .height(request.getHeight())
                .city(city)
                .build();
        map = gameMapRepository.save(map);

        city.setGameMap(map);
        cityRepository.save(city);

        return CityResponse.builder()
                .cityId(city.getId())
                .cityName(city.getName())
                .mapId(map.getId())
                .width(map.getWidth())
                .height(map.getHeight())
                .message("Город и карта успешно созданы")
                .build();
    }


}
