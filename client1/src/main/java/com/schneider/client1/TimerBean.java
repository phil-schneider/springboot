package com.schneider.client1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RefreshScope
public class TimerBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimerBean.class);

    @Scheduled(fixedRateString = "${timerbean.fixedRate:30000}")
    private void doRefresh() {
        LOGGER.info("Calling refresh");
    }
}
