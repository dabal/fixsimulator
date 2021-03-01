package com.github.dabal.fixsimulator.fix;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Component

@Slf4j
public class MockConfiguration {

    Map<String, Object> configuration;
    String pathToConfiguration;

    @Autowired
    public MockConfiguration(@Value("${mockConfigurationPath}") String pathToConfiguration){
        this.pathToConfiguration=pathToConfiguration;
        log.info(pathToConfiguration);
    }

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("file:"+pathToConfiguration);
        configuration = (Map<String, Object>)objectMapper.readValue(url, Object.class);

    }



}
