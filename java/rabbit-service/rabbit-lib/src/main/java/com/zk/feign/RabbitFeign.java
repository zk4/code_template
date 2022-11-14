package com.zk.feign;

import com.zk.api.RabbitAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "rabbit-service")
public interface RabbitFeign extends RabbitAPI {
}