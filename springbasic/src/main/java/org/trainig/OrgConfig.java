package org.trainig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrgConfig {
    @Bean
    public TestAppRun testAppRun(){
        return new TestAppRun();
    }

}
