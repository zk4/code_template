package com.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        //Hole hole = new Hole();
        //int i = hole.countRabbit();
        //System.out.println(i);
        SpringApplication app = new SpringApplication(App.class);
        ConfigurableApplicationContext run = app.run(args);

    }
}


