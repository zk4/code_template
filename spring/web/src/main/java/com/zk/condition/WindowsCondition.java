package com.zk.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 得到 ioc 的 bean factory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获得类加载器
        ClassLoader classLoader = context.getClassLoader();

        Environment environment = context.getEnvironment();

        String osName = environment.getProperty("os.name");

        return osName.contains("Windows");



    }

}
