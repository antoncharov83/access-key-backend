package com.example.accesskeybackend.config;

import com.example.accesskeybackend.props.AccessKeyProviderProps;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder, final AccessKeyProviderProps props) {
        return builder
                .rootUri(props.getRootUri())
                .basicAuthentication(props.getAuthUser(), props.getAuthPwd())
                .defaultHeader("user-agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0")
                .build();
    }
}
