package com.simplon.quizz.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simplon.quizz.converter.StringToEnumConverter;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        super();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }

}
