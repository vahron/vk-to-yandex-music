package com.pashkan.vktoyandexmusic.mover;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MoverTask {

    @Scheduled(fixedDelay = 5000)
    public void checkMusic() {
    }
}
