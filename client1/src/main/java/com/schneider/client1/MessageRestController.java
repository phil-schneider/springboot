package com.schneider.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageRestController {

    @Value("${messagerest.message:Hello default}")
    private String message;

    @Value("${messagerest.execption:false}")
    private boolean throwException;

    @Value("${messagerest.sleeptime:0}")
    private long sleeptime;

    @RequestMapping("/message")
    String getMessage() {
        if (throwException){
            throw new RuntimeException("runtime");
        }
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ignore) {
           //ignore
        }
        return this.message;
    }


}

