package com.zk.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "zk.hello")
public class SampleProperties {

	private String host;
	private  Integer port;

	public String getHost() {
		return host;
	}

	public SampleProperties setHost(String host) {
		this.host = host;
		return this;
	}

	public Integer getPort() {
		return port;
	}

	public SampleProperties setPort(Integer port) {
		this.port = port;
		return this;
	}
}
