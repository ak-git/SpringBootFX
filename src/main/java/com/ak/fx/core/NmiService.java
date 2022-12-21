package com.ak.fx.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Profile("nmi")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class NmiService extends AbstractService {
}
