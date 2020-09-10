package com.spring.springbeandemo.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean
    public CD getCD(){
        return new CD();
    }

    @Bean(name = "play")
    public Play getPlay(CD cd){
        Play play = new Play();
        play.setCd(cd);
        return play;
    }
}
