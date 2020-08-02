package com.ak.fx.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AperConfiguration {
  @Bean
  @Profile("aper")
  Service aper() {
    return new AperService(getClass().getSimpleName());
  }
}
