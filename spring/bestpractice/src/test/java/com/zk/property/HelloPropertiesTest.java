package com.zk.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloPropertiesTest {
    @Autowired
    private SampleProperties helloProperties;



    @Test
    public void preix() {

        assertThat(helloProperties.getHost()).isEqualTo("127.0.0.1");
        assertThat(helloProperties.getPort()).isEqualTo(1222);
    }



}