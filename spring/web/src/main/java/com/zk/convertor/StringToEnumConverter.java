package com.zk.convertor;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Modes> {
 
    @Override
    public Modes convert(String from) {
        return Modes.valueOf(from);
    }
}