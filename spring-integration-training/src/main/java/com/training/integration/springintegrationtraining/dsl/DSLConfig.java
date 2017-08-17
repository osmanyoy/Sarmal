package com.training.integration.springintegrationtraining.dsl;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
public class DSLConfig {

    @Bean
    public MessageChannel firstDSLChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel secondDSLChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel discardDSLChannel() {
        return new DirectChannel();
    }

    @Bean
    public FilterBean filterBean() {
        return new FilterBean();
    }

    @Bean
    public IntegrationFlow discardFlow() {
        return f -> f.channel(discardDSLChannel())
                     .handle(z -> z.getPayload()
                                   .toString()
                                   .concat(" DSL Discarded")
                     );
    }

//    @Bean
//    public IntegrationFlow integrationFlow() {
//        return f -> f.channel(firstDSLChannel())
//                     .filter("@filterBean.decide(payload)")
//                     .channel(secondDSLChannel())
//                     .handle(z -> z.getPayload()
//                                   .toString());
//    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return f -> f.channel(firstDSLChannel())
                     .filter("@filterBean.decide(payload)",
                             fs -> fs.discardChannel("discardDSLChannel"))
                     .channel(secondDSLChannel())
                     .handle(z -> z.getPayload()
                                   .toString());
    }

}
