package com.town.game.server;

import com.town.game.dto.BuildingRequest;
import com.town.game.dto.BuildingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceImpl implements WebService{
    @Override
    public BuildingResponse build(BuildingRequest buildingRequest){
        return null;

    }

}
