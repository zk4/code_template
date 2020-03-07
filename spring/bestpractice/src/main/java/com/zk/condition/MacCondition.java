package com.zk.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MacCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 得到 ioc 的 bean factory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获得类加载器
        ClassLoader classLoader = context.getClassLoader();

        Environment environment = context.getEnvironment();

        String osName = environment.getProperty("os.name");

        boolean mac_os_x = osName.equals("Mac OS X");

        return mac_os_x;



    }

    public static void main(String[] args) {
        String name = System.getProperty("os.name");
        System.out.println(name);

    }
}
