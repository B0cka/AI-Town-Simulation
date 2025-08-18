package com.town.game.models.ai;

import lombok.Data;

import java.util.List;

@Data
public class AiResponse {

    private String model;
    private String createdAt;
    private String response;
    private boolean done;
    private String doneReason;
    private List<Long> context;
    private long totalDuration;
    private long loadDuration;
    private int promptEvalCount;
    private long promptEvalDuration;
    private int evalCount;
    private long evalDuration;


}
