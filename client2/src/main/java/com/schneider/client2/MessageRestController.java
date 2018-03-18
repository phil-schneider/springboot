package com.schneider.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    @Autowired
    private MessageBean messageBean;

    @RequestMapping("/message")
    public String getMessage() {
           return messageBean.getMessage();

    }


}

