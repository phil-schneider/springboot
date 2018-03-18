package com.schneider.client2;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.net.URI;

@Service
public class MessageBean {


    @HystrixCommand(fallbackMethod = "reliable")
    public String getMessage() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8899/message");
        return restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
