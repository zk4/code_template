package com.zk.api;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RabbitAPI {

    @Data
    class Req {
        String name;
        String age;
    }

    @PostMapping("/demo/list")
    String demo(@RequestBody Req demoFeignQueryVO);
    
}
