package org.machina;

import org.springframework.context.annotation.Bean;

/**
 * @author alopez@wombatsecurity.com on 1/26/16.
 */
public class Configuration {

    @Bean
    public Slipknot slipknot() throws Exception {
        Slipknot slipknot = new Slipknot();
        slipknot.postConstruct();
        return slipknot;
    }
}
