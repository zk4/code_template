package com.zk.config;

import com.zk.convertor.StringToEnumConverter;
import com.zk.util.DebugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
	
	@Autowired
	UserArgumentResolver userArgumentResolver;


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		StringToEnumConverter proxyme = DebugUtil.traceCall(StringToEnumConverter.class);
		registry.addConverter(proxyme);
	}

}
