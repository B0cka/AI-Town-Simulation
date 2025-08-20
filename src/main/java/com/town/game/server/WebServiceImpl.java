package com.town.game.server;

import com.town.game.dto.BuildingRequest;
import com.town.game.dto.BuildingResponse;
import com.town.game.dto.CityResponse;
import com.town.game.dto.MapCityRequest;
import com.town.game.models.CellsType;
import com.town.game.models.game.Cell;
import com.town.game.models.game.City;
import com.town.game.models.game.GameMap;
import com.town.game.repository.CellRepository;
import com.town.game.repository.CityRepository;
import com.town.game.repository.GameMapRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceImpl implements WebService{

    private final CityRepository cityRepository;
    private final GameMapRepository gameMapRepository;
    private final CellRepository cellRepository;

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
        generateCellsForMap(map);
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

    private void generateCellsForMap(GameMap map) {
        List<Cell> cells = new ArrayList<>();

        for (long x = 0; x < map.getWidth(); x++) {
            for (long y = 0; y < map.getHeight(); y++) {
                Cell cell = Cell.builder()
                        .x(x)
                        .y(y)
                        .type(CellsType.Grass)
                        .gameMap(map)  // Связь с картой
                        .build();
                cells.add(cell);
            }
        }

        cellRepository.saveAll(cells);  // Сохраняем все сразу
    }


}
