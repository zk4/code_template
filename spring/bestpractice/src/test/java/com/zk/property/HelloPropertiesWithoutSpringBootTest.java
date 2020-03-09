package com.zk.property;

import com.zk.App;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloPropertiesWithoutSpringBootTest {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @After
    public void closeContext() {
        this.context.close();
    }


    @Test
    public void bindValidProperties() {
        this.context.register(App.class);
        TestPropertyValues.of("zk.hello.host:192.168.0.1", "zk.hello.port:9090")
                .applyTo(this.context);
        this.context.refresh();
        SampleProperties properties = this.context.getBean(SampleProperties.class);

        assertThat(properties.getHost()).isEqualTo("192.168.0.1");
        assertThat(properties.getPort()).isEqualTo(9090);

    }


}