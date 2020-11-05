package com.ak.fx.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AperConfiguration {
  @Bean
  @Profile("aper")
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  AperService aper() {
    return new AperService(getClass().getSimpleName());
  }
}
