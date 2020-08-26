package com.simplon.quizz.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import com.simplon.quizz.entities.Difuculte;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverter implements Converter<String, Difuculte> {
    @Override
    public  Difuculte convert(String source) {
        return Difuculte.valueOf(source.toUpperCase());
    }

 
}