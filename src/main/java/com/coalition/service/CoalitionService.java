package com.coalition.service;

import com.coalition.entity.CoalitionEntry;
import com.coalition.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoalitionService {
    private static final Logger logger = LoggerFactory.getLogger(CoalitionService.class);

    private final RestTemplate restTemplate;

    public CoalitionService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String fetchNominator(User user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user.getUserName());
        CoalitionEntry result = restTemplate.getForObject(url, CoalitionEntry.class);

        logger.info("Get result " + result);

        return result.getType();
    }

}
